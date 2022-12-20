package spring.hello.data.jedis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.jedis.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}