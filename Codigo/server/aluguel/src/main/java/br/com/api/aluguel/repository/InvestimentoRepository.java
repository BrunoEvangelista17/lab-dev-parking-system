package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.InvestimentoEntity;

public interface InvestimentoRepository extends JpaRepository<InvestimentoEntity, Long> {
}