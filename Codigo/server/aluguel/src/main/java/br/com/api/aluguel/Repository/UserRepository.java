package br.com.api.aluguel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.service.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
