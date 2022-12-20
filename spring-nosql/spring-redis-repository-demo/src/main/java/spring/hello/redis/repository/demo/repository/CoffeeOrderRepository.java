package spring.hello.redis.repository.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.redis.repository.demo.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}