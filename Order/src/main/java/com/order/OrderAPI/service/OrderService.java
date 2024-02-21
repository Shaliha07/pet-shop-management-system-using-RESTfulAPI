package com.order.OrderAPI.service;

import com.order.OrderAPI.model.Order;
import com.order.OrderAPI.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    public Order createOrder(Order order) {

        order.setOrderDate(LocalDateTime.now());

        return orderRepository.save(order);
    }
    public String deleteOrder(int user) {
        orderRepository.deleteById(user);
        if (orderRepository.findById(user).isPresent()) {
            return "Not Deleted";
        } else {
            return "Deleted";
        }

    }
}

