package br.com.api.aluguel.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import br.com.api.aluguel.Repository.ClienteRepository;
import br.com.api.aluguel.Repository.UserRepository;
import br.com.api.aluguel.service.Cliente;
import br.com.api.aluguel.service.User;


import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

   @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        if (cliente.getUser() == null || cliente.getUser().getId() == null) {
            throw new IllegalArgumentException("O campo 'user' não pode ser nulo ou sem ID");
        }

        Optional<User> userOpt = userRepository.findById(cliente.getUser().getId());
        
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("Usuário com ID " + cliente.getUser().getId() + " não encontrado");
        }

        cliente.setUser(userOpt.get());
        return clienteRepository.save(cliente);
}


    @GetMapping("/all")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
}

