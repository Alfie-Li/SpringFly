package spring.hello.data.cache.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.cache.redis.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}