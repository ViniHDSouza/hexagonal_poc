package com.example.product.application.port.in;

import com.example.product.domain.model.Product;
import java.util.List;

public interface ProductUseCase {
    Product create(Product product);
    List<Product> findAll();
    Product findById(Long id);
    Product update(Long id, Product product);
    void delete(Long id);
}