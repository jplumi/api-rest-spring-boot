package com.produtos.apiRest.resources;

import com.produtos.apiRest.models.Product;
import com.produtos.apiRest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/products")
@Api(value = "API REST Product")
@CrossOrigin(origins = "*") // qualquer domínio pode acessar esta API
public class ProductResource {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os produtos")
    public List<Product> listProducts() {
        return repository.findAll();
    }

    @DeleteMapping
    @ApiOperation(value = "Delata um produto")
    public void deleteProduct(@RequestBody Product product) {
        repository.delete(product);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza um produto")
    public Product updateProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo produto")
    public Product saveProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o produto correspondente ao ID")
    public Product listProductById(@PathVariable Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

}
