package com.order.OrderAPI.repository;

import com.order.OrderAPI.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
