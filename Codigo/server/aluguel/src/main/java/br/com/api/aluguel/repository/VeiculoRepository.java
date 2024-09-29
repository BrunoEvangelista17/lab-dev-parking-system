package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.VeiculoEntity;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
}