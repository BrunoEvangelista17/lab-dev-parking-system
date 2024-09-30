package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}