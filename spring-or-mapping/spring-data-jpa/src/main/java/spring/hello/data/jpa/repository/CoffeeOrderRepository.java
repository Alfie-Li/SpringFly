package spring.hello.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import spring.hello.data.jpa.model.CoffeeOrder;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
