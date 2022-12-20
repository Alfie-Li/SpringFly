package spring.hello.data.jedis.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.data.jedis.demo.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}