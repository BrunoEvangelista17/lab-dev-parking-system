package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.Investimento;
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
    public List<Investimento> listar() {
        return (List<Investimento>) investimentoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Investimento> buscarPorId(@PathVariable Long id) {
        return investimentoService.buscarPorId(id);
    }

    @PostMapping
    public Investimento criar(@RequestBody Investimento investimento) {
        return investimentoService.salvar(investimento);
    }

    @PutMapping("/{id}")
    public Investimento atualizar(@PathVariable Long id, @RequestBody Investimento investimento) {
        investimento.setId(id);
        return investimentoService.salvar(investimento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        investimentoService.deletar(id);
    }
}