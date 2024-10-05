package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.Veiculo;
import br.com.api.aluguel.repository.VeiculoRepository;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository vr;

    public Iterable<Veiculo> listar() {
        return vr.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return vr.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return vr.save(veiculo);
    }

    public void deletar(Long id) {
        vr.deleteById(id);
    }
}