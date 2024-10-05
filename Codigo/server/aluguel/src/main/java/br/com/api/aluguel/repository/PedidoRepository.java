package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.api.aluguel.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}