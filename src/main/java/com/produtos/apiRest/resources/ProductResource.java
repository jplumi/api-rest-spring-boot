package com.produtos.apiRest.resources;

import com.produtos.apiRest.models.Product;
import com.produtos.apiRest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> listProducts() {
        return repository.findAll();
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        repository.delete(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/{id}")
    public Product listProductById(@PathVariable Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
