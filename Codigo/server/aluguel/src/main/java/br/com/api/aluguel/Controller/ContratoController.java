package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.Contrato;
import br.com.api.aluguel.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Contrato") // Rota: "http://localhost:8080/Contrato"
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listar() {
        return (List<Contrato>) contratoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Contrato> buscarPorId(@PathVariable Long id) {
        return contratoService.buscarPorId(id);
    }

    @PostMapping
    public Contrato criar(@RequestBody Contrato contrato) {
        return contratoService.salvar(contrato);
    }

    @PutMapping("/{id}")
    public Contrato atualizar(@PathVariable Long id, @RequestBody Contrato contrato) {
        contrato.setId(id);
        return contratoService.salvar(contrato);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        contratoService.deletar(id);
    }
}