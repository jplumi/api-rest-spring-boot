package com.produtos.apiRest.resources;

import com.produtos.apiRest.models.User;
import com.produtos.apiRest.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
@Api(value = "API REST User")
@CrossOrigin(origins = "*") // qualquer domínio pode acessar esta API
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista com todos os usuários")
    public List<User> listUsers() {
        return repository.findAll();
    }

    @DeleteMapping
    @ApiOperation(value = "Delata um usuário")
    public void deleteUser(@RequestBody User User) {
        repository.delete(User);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza um usuário")
    public User updateUser(@RequestBody User User) {
        return repository.save(User);
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo usuário")
    public User saveUser(@RequestBody User User) {
        return repository.save(User);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna o usuário correspondente ao ID")
    public User listUserById(@PathVariable Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

}
