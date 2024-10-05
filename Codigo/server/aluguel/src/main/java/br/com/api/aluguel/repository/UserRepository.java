package br.com.api.aluguel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
