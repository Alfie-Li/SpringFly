package spring.hello.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hello.springbucks.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}

