package com.msi.productorderapi.repository;

import com.msi.productorderapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAll();

    Order findOrderById(Integer id);
}
