package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.PedidoEntity;
import br.com.api.aluguel.repository.PedidoRepository;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pr;

    public Iterable<PedidoEntity> listar() {
        return pr.findAll();
    }

    public Optional<PedidoEntity> buscarPorId(Long id) {
        return pr.findById(id);
    }

    public PedidoEntity salvar(PedidoEntity pedido) {
        return pr.save(pedido);
    }

    public void deletar(Long id) {
        pr.deleteById(id);
    }
}