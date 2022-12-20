package spring.hello.redis.repository.demo.repository;

import org.springframework.data.repository.CrudRepository;
import spring.hello.redis.repository.demo.model.CoffeeCache;

import java.util.Optional;

public interface CoffeeCacheRepository extends CrudRepository<CoffeeCache, Long> {

    Optional<CoffeeCache> findOneByName(String name);
}
