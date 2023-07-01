package com.example.mystore.service;

import com.example.mystore.model.Product;
import com.example.mystore.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(int id) {
        return productRepository.getReferenceById(id);
    }

    public List<Product> getByCategoryId(int id) {
        return productRepository.getByIdCategory(id);
    }

    public List<Product> getByPatternName(String pattern) {
        return productRepository.getByPatternName(pattern);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}
