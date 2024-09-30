package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.ClienteEntity;
import br.com.api.aluguel.repository.ClienteRepository;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository cs;

    public Iterable<ClienteEntity> listar(){
        return cs.findAll();
    }

    public Optional<ClienteEntity> buscarPorId(Long id) {
        return cs.findById(id);
    }

    public ClienteEntity salvar(ClienteEntity cliente) {
        return cs.save(cliente);
    }

    public void deletar(Long id) {
        cs.deleteById(id);
    }
}
