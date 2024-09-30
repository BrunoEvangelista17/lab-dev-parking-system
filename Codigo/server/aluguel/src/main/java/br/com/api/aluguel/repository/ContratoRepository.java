package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.ContratoEntity;

public interface ContratoRepository extends JpaRepository<ContratoEntity, Long> {
}