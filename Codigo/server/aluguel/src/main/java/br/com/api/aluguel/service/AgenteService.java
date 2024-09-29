package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.AgenteEntity;
import br.com.api.aluguel.repository.AgenteRepository;

import java.util.Optional;

@Service
public class AgenteService {
    
    @Autowired
    private AgenteRepository as;

     public Iterable<AgenteEntity> listar(){
        return as.findAll();
    }

    public Optional<AgenteEntity> buscarPorId(Long id) {
        return as.findById(id);
    }

    public AgenteEntity salvar(AgenteEntity cliente) {
        return as.save(cliente);
    }

    public void deletar(Long id) {
        as.deleteById(id);
    }
}
