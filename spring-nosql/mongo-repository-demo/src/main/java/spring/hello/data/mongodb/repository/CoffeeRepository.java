package spring.hello.data.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.hello.data.mongodb.model.Coffee;

import java.util.List;

public interface CoffeeRepository extends MongoRepository<Coffee, String> {

    List<Coffee> findByName(String name);
}
