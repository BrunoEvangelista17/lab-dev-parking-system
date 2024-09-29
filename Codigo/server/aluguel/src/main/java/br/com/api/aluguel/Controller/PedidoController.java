package br.com.api.aluguel.controller;

import br.com.api.aluguel.model.PedidoEntity;
import br.com.api.aluguel.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pedido") // Rota: "http://localhost:8080/Pedido"
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoEntity> listar() {
        return (List<PedidoEntity>) pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<PedidoEntity> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public PedidoEntity criar(@RequestBody PedidoEntity pedido) {
        return pedidoService.salvar(pedido);
    }

    @PutMapping("/{id}")
    public PedidoEntity atualizar(@PathVariable Long id, @RequestBody PedidoEntity pedido) {
        pedido.setId(id);
        return pedidoService.salvar(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }
}