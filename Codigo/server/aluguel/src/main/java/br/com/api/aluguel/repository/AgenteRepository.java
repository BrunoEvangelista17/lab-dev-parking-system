package br.com.api.aluguel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.model.AgenteEntity;
public interface AgenteRepository extends JpaRepository<AgenteEntity, Long>  {
    
}
