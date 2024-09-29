package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.AgenteEntity;
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
    public List<AgenteEntity> listar() {
        return (List<AgenteEntity>) agenteService.listar();
    }

    @GetMapping("/{id}")
    public Optional<AgenteEntity> buscarPorId(@PathVariable Long id) {
        return agenteService.buscarPorId(id);
    }

    @PostMapping
    public AgenteEntity criar(@RequestBody AgenteEntity agente) {
        return agenteService.salvar(agente);
    }

    @PutMapping("/{id}")
    public AgenteEntity atualizar(@PathVariable Long id, @RequestBody AgenteEntity agente) {
        agente.setId(id);
        return agenteService.salvar(agente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        agenteService.deletar(id);
    }
}
