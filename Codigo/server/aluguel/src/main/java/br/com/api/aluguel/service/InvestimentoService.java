package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.Investimento;
import br.com.api.aluguel.repository.InvestimentoRepository;

import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository ir;

    public Iterable<Investimento> listar() {
        return ir.findAll();
    }

    public Optional<Investimento> buscarPorId(Long id) {
        return ir.findById(id);
    }

    public Investimento salvar(Investimento investimento) {
        return ir.save(investimento);
    }

    public void deletar(Long id) {
        ir.deleteById(id);
    }
}