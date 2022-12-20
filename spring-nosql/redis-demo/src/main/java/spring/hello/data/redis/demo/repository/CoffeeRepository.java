package spring.hello.data.redis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.redis.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
