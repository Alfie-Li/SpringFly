package spring.hello.data.jpa.complex.repository;

import spring.hello.data.jpa.complex.model.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderRepository extends BaseRepository<CoffeeOrder, Long> {

    List<CoffeeOrder> findByCustomerOrderById(String customer);
    // 防止混淆，加了_
    List<CoffeeOrder> findByItems_Name(String name);

}
