package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.ContratoEntity;
import br.com.api.aluguel.repository.ContratoRepository;

import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository cr;

    public Iterable<ContratoEntity> listar() {
        return cr.findAll();
    }

    public Optional<ContratoEntity> buscarPorId(Long id) {
        return cr.findById(id);
    }

    public ContratoEntity salvar(ContratoEntity contrato) {
        return cr.save(contrato);
    }

    public void deletar(Long id) {
        cr.deleteById(id);
    }
}