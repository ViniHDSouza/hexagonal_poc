package com.example.product.application.service;

import com.example.product.application.port.in.ProductUseCase;
import com.example.product.application.port.out.ProductRepositoryPort;
import com.example.product.domain.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort repository;

    public ProductService(ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product update(Long id, Product product) {
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}