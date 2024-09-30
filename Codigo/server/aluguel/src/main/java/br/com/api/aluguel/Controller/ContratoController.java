package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.ContratoEntity;
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
    public List<ContratoEntity> listar() {
        return (List<ContratoEntity>) contratoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<ContratoEntity> buscarPorId(@PathVariable Long id) {
        return contratoService.buscarPorId(id);
    }

    @PostMapping
    public ContratoEntity criar(@RequestBody ContratoEntity contrato) {
        return contratoService.salvar(contrato);
    }

    @PutMapping("/{id}")
    public ContratoEntity atualizar(@PathVariable Long id, @RequestBody ContratoEntity contrato) {
        contrato.setId(id);
        return contratoService.salvar(contrato);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        contratoService.deletar(id);
    }
}