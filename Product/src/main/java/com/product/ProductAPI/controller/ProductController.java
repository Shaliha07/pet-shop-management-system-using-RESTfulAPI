package com.product.ProductAPI.controller;

import com.product.ProductAPI.model.Product;
import com.product.ProductAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("product/{product_id}")
    public Product getProduct(@PathVariable int product_id){
        return productService.getProduct(product_id);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/productByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteProductById(@PathVariable int id){
        return productService.deleteProduct(id);
    }

}


