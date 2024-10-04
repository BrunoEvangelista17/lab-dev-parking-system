package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.Agente;
import br.com.api.aluguel.repository.AgenteRepository;

import java.util.Optional;

@Service
public class AgenteService {
    
    @Autowired
    private AgenteRepository as;

     public Iterable<Agente> listar(){
        return as.findAll();
    }

    public Optional<Agente> buscarPorId(Long id) {
        return as.findById(id);
    }

    public Agente salvar(Agente cliente) {
        return as.save(cliente);
    }

    public void deletar(Long id) {
        as.deleteById(id);
    }
}
