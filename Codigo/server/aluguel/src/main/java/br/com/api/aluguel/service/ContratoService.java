package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.Contrato;
import br.com.api.aluguel.repository.ContratoRepository;

import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository cr;

    public Iterable<Contrato> listar() {
        return cr.findAll();
    }

    public Optional<Contrato> buscarPorId(Long id) {
        return cr.findById(id);
    }

    public Contrato salvar(Contrato contrato) {
        return cr.save(contrato);
    }

    public void deletar(Long id) {
        cr.deleteById(id);
    }
}