package spring.hello.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.springbucks.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}