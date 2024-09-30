package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.InvestimentoEntity;
import br.com.api.aluguel.repository.InvestimentoRepository;

import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentoRepository ir;

    public Iterable<InvestimentoEntity> listar() {
        return ir.findAll();
    }

    public Optional<InvestimentoEntity> buscarPorId(Long id) {
        return ir.findById(id);
    }

    public InvestimentoEntity salvar(InvestimentoEntity investimento) {
        return ir.save(investimento);
    }

    public void deletar(Long id) {
        ir.deleteById(id);
    }
}