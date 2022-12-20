package spring.hello.data.cache.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.cache.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
