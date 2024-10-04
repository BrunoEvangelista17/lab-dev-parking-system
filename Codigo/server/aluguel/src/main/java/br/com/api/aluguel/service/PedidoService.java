package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.Pedido;
import br.com.api.aluguel.repository.PedidoRepository;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pr;

    public Iterable<Pedido> listar() {
        return pr.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pr.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        return pr.save(pedido);
    }

    public void deletar(Long id) {
        pr.deleteById(id);
    }
}