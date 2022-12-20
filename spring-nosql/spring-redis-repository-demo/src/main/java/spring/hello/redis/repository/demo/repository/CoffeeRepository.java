package spring.hello.redis.repository.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.redis.repository.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
