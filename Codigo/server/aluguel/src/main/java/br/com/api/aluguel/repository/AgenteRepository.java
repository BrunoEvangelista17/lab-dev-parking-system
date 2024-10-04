package br.com.api.aluguel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.model.Agente;
public interface AgenteRepository extends JpaRepository<Agente, Long>  {
    
}
