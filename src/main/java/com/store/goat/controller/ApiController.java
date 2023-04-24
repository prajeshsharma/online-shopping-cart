package com.store.goat.controller;

import com.store.goat.dao.Product;
import com.store.goat.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) return opt.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
