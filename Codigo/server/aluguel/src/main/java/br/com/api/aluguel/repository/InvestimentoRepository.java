package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}