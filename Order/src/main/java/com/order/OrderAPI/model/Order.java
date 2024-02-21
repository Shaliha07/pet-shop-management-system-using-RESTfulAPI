package com.order.OrderAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblOrder")
public class Order {
          @Id
          @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderItem> orderItems = new ArrayList<>();

        private LocalDateTime orderDate;

        private BigDecimal totalAmount;


        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public List<OrderItem> getOrderItems() {
                return orderItems;
        }

        public void setOrderItems(List<OrderItem> orderItems) {
                this.orderItems = orderItems;
        }

        public LocalDateTime getOrderDate() {
                return orderDate;
        }

        public void setOrderDate(LocalDateTime orderDate) {
                this.orderDate = orderDate;
        }

        public BigDecimal getTotalAmount() {
                return totalAmount;
        }

        public void setTotalAmount(BigDecimal totalAmount) {
                this.totalAmount = totalAmount;
        }
}
