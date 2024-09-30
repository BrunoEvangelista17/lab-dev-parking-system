package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.VeiculoEntity;
import br.com.api.aluguel.repository.VeiculoRepository;

import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository vr;

    public Iterable<VeiculoEntity> listar() {
        return vr.findAll();
    }

    public Optional<VeiculoEntity> buscarPorId(Long id) {
        return vr.findById(id);
    }

    public VeiculoEntity salvar(VeiculoEntity veiculo) {
        return vr.save(veiculo);
    }

    public void deletar(Long id) {
        vr.deleteById(id);
    }
}