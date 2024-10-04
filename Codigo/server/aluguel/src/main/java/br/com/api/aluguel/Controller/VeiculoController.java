package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.Veiculo;
import br.com.api.aluguel.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Veiculo") // Rota: "http://localhost:8080/Veiculo"
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> listar() {
        return (List<Veiculo>) veiculoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Veiculo> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    @PostMapping
    public Veiculo criar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        veiculo.setId(id);
        return veiculoService.salvar(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
    }
}