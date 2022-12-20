package spring.hello.redis.repository.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import spring.hello.redis.repository.demo.model.Coffee;
import spring.hello.redis.repository.demo.model.CoffeeCache;
import spring.hello.redis.repository.demo.repository.CoffeeCacheRepository;
import spring.hello.redis.repository.demo.repository.CoffeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
@Slf4j
public class CoffeeService {
    private static final String CACHE = "springbucks-coffee";
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeCacheRepository cacheRepository;

    public List<Coffee> findAllCoffee(){
        return coffeeRepository.findAll();
    }

    public Optional<Coffee> findSimpleCoffeeFromCache(String name){
        Optional<CoffeeCache> cached = cacheRepository.findOneByName(name);
        if(cached.isPresent()){
            // 命中redis缓存
            CoffeeCache coffeeCache = cached.get();
            Coffee coffee = Coffee.builder()
                    .name(coffeeCache.getName())
                    .price(coffeeCache.getPrice())
                    .build();
            log.info("Coffee {} found in cache.", coffeeCache);
            return Optional.of(coffee);
        }else{
            Optional<Coffee> coffee = getCoffee(name);
            coffee.ifPresent(c -> {
                CoffeeCache coffeeCache = CoffeeCache.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .price(c.getPrice())
                        .build();
                log.info("Save Coffee {} to cache.", coffeeCache);
                cacheRepository.save(coffeeCache);
            });
            return coffee;
        }

    }

    private Optional<Coffee> getCoffee(String name) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", exact().ignoreCase());
        Optional<Coffee> coffee = coffeeRepository.findOne(
                Example.of(Coffee.builder().name(name).build(), matcher)
        );
        log.info("Coffee Found: {}", coffee);
        return coffee;
    }
}
