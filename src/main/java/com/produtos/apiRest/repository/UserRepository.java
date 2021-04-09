package com.produtos.apiRest.repository;

import com.produtos.apiRest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
