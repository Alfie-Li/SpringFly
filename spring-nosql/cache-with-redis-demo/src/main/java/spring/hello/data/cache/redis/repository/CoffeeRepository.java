package spring.hello.data.cache.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.cache.redis.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
