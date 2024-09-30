package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.UserEntity;
import br.com.api.aluguel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/User")//rota: "http://localhost:8080/User"
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> listar() {
        return (List<UserEntity>) userService.listar();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }

    @PostMapping
    public UserEntity criar(@RequestBody UserEntity user) {
        return userService.salvar(user);
    }

    @PutMapping("/{id}")
    public UserEntity atualizar(@PathVariable Long id, @RequestBody UserEntity user) {
        user.setId(id);
        return userService.salvar(user);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        userService.deletar(id);
    }
}