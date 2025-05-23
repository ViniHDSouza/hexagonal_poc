package com.example.product.infrastructure.adapter.out.persistence;

import com.example.product.application.port.out.ProductRepositoryPort;
import com.example.product.domain.model.Product;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository repository;

    public ProductRepositoryAdapter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        ProductEntity saved = repository.save(entity);
        product.setId(saved.getId());
        return product;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(e -> new Product(e.getId(), e.getName(), e.getPrice())).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id).map(e -> new Product(e.getId(), e.getName(), e.getPrice()));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}