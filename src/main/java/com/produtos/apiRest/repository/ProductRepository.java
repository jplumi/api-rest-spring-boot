package com.produtos.apiRest.repository;

import com.produtos.apiRest.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
