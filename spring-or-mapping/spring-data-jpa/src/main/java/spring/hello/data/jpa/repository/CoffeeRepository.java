package spring.hello.data.jpa.repository;

import org.springframework.data.repository.CrudRepository;
import spring.hello.data.jpa.model.Coffee;

public interface  CoffeeRepository  extends CrudRepository<Coffee, Long> {
}
