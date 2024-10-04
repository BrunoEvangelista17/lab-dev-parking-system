package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}