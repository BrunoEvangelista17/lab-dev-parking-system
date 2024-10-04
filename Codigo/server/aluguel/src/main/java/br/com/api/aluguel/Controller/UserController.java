package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.User;
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
    public List<User> listar() {
        return (List<User>) userService.listar();
    }

    @GetMapping("/{id}")
    public Optional<User> buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }

    @PostMapping
    public User criar(@RequestBody User user) {
        return userService.salvar(user);
    }

    @PutMapping("/{id}")
    public User atualizar(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.salvar(user);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        userService.deletar(id);
    }
}