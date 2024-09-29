package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.VeiculoEntity;
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
    public List<VeiculoEntity> listar() {
        return (List<VeiculoEntity>) veiculoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<VeiculoEntity> buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    @PostMapping
    public VeiculoEntity criar(@RequestBody VeiculoEntity veiculo) {
        return veiculoService.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public VeiculoEntity atualizar(@PathVariable Long id, @RequestBody VeiculoEntity veiculo) {
        veiculo.setId(id);
        return veiculoService.salvar(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
    }
}