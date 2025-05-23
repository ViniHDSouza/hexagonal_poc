package com.example.product.infrastructure.adapter.in.web;

import com.example.product.application.port.in.ProductUseCase;
import com.example.product.domain.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productUseCase.create(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productUseCase.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productUseCase.findById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productUseCase.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productUseCase.delete(id);
    }
}