package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.ClienteEntity;
import br.com.api.aluguel.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cliente") // Rota: "http://localhost:8080/Cliente"
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteEntity> listar() {
        return (List<ClienteEntity>) clienteService.listar();
    }

    @GetMapping("/{id}")
    public Optional<ClienteEntity> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ClienteEntity criar(@RequestBody ClienteEntity cliente) {
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ClienteEntity atualizar(@PathVariable Long id, @RequestBody ClienteEntity cliente) {
        cliente.setId(id);
        return clienteService.salvar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}