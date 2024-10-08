package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.Agente;
import br.com.api.aluguel.service.AgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Agente")// Rota: "http://localhost:8080/Agente"
public class AgenteController {
    
    @Autowired
    private AgenteService agenteService;

    @GetMapping
    public List<Agente> listar() {
        return (List<Agente>) agenteService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Agente> buscarPorId(@PathVariable Long id) {
        return agenteService.buscarPorId(id);
    }

    @PostMapping
    public Agente criar(@RequestBody Agente agente) {
        return agenteService.salvar(agente);
    }

    @PutMapping("/{id}")
    public Agente atualizar(@PathVariable Long id, @RequestBody Agente agente) {
        agente.setId(id);
        return agenteService.salvar(agente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agenteService.deletar(id);
    }
}
