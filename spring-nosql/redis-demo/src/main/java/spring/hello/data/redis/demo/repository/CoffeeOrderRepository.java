package spring.hello.data.redis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.redis.demo.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}