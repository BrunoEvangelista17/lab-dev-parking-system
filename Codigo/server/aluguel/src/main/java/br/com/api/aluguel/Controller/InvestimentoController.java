package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.InvestimentoEntity;
import br.com.api.aluguel.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Investimento") // Rota: "http://localhost:8080/Investimento"
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @GetMapping
    public List<InvestimentoEntity> listar() {
        return (List<InvestimentoEntity>) investimentoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<InvestimentoEntity> buscarPorId(@PathVariable Long id) {
        return investimentoService.buscarPorId(id);
    }

    @PostMapping
    public InvestimentoEntity criar(@RequestBody InvestimentoEntity investimento) {
        return investimentoService.salvar(investimento);
    }

    @PutMapping("/{id}")
    public InvestimentoEntity atualizar(@PathVariable Long id, @RequestBody InvestimentoEntity investimento) {
        investimento.setId(id);
        return investimentoService.salvar(investimento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        investimentoService.deletar(id);
    }
}