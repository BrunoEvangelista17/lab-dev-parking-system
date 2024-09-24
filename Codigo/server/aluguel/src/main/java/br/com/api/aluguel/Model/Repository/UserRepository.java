package br.com.api.aluguel.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.aluguel.service.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
