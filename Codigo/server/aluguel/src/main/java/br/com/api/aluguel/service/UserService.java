package br.com.api.aluguel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.aluguel.model.User;
import br.com.api.aluguel.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository us;

    public Iterable<User> listar(){
        return us.findAll();
    }

    public Optional<User> buscarPorId(Long id) {
        return us.findById(id);
    }

    public User salvar(User user) {
        return us.save(user);
    }

    public void deletar(Long id) {
        us.deleteById(id);
    }
}