package com.product.ProductAPI.service;

import com.product.ProductAPI.model.Product;
import com.product.ProductAPI.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){

        return productRepository.save(product);
    }
    public Product getProduct(int product){

        return productRepository.findById(product).orElse(null);
    }
    public List<Product> getAllProduct(){

        return productRepository.findAll();
    }
    public Product getProductByName(String name){

        return productRepository.findbyName(name);
    }
    public String deleteProduct(int product) {
        productRepository.deleteById(product);
        if (productRepository.findById(product).isPresent()) {
            return "Not Deleted";
        } else {
            return "Deleted";
        }

    }

}
