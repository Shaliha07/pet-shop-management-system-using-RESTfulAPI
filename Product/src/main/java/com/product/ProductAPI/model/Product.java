package com.product.ProductAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblproduct")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

       private int id;
        private String name;

        private String description;

        private double price;

        private int stockQuantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
