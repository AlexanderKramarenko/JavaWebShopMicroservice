package ru.alexander_kramarenko.java_web_shop_v11.core.repositories;

import ru.alexander_kramarenko.java_web_shop_v11.core.model.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.username = :username")
    @EntityGraph(value = "orders.for-front")
    List<Order> findAllByUsername(String username);
}
