package spring.hello.data.cache.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.cache.demo.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}