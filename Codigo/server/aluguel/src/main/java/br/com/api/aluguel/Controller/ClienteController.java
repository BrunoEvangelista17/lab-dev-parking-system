package br.com.api.aluguel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import br.com.api.aluguel.model.ClienteEntity;
import br.com.api.aluguel.model.UserEntity;
import br.com.api.aluguel.repository.ClienteRepository;
import br.com.api.aluguel.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ClienteEntity addCliente(@RequestBody ClienteEntity cliente) {
        if (cliente.getUser() == null || cliente.getUser().getId() == null) {
            throw new IllegalArgumentException("O campo 'user' não pode ser nulo ou sem ID");
        }

        Optional<UserEntity> userOpt = userRepository.findById(cliente.getUser().getId());
        
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("Usuário com ID " + cliente.getUser().getId() + " não encontrado");
        }

        cliente.setUser(userOpt.get());
        return clienteRepository.save(cliente);
}


    @GetMapping("/all")
    public List<ClienteEntity> getAllClientes() {
        return clienteRepository.findAll();
    }
}

