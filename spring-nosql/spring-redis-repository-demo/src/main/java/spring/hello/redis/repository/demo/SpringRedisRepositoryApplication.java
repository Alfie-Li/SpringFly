package spring.hello.redis.repository.demo;

import io.lettuce.core.ReadFrom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.hello.redis.repository.demo.converter.BytesToMoneyConverter;
import spring.hello.redis.repository.demo.converter.MoneyToBytesConverter;
import spring.hello.redis.repository.demo.model.Coffee;
import spring.hello.redis.repository.demo.service.CoffeeService;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories
@EnableTransactionManagement
@EnableRedisRepositories
public class SpringRedisRepositoryApplication implements ApplicationRunner {

    @Autowired
    private CoffeeService coffeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisRepositoryApplication.class, args);
    }

    @Bean
    public LettuceClientConfigurationBuilderCustomizer customizer(){
        return builder -> builder.readFrom(ReadFrom.MASTER_PREFERRED);
    }

    @Bean
    // 金额 序列化和反序列化操作
    // 解决Cannot set property currency because no setter, no wither and it's not part of the persistence constructor private org.joda.money.BigMoney()
    public RedisCustomConversions redisCustomConversions(){
        return new RedisCustomConversions(
                Arrays.asList(new MoneyToBytesConverter(), new BytesToMoneyConverter())
        );
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<Coffee> c = coffeeService.findSimpleCoffeeFromCache("mocha");
        log.info("Coffee {}", c);

        for (int i = 0; i < 5; i++) {
            c = coffeeService.findSimpleCoffeeFromCache("mocha");
        }

        log.info("Value from Redis: {}", c);
    }
}
