package br.com.api.aluguel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User\"")  // Nome da tabela com aspas duplas para manter a maiúscula
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    // Construtor padrão
    public UserEntity(){}

    // Construtor com parâmetros
    public UserEntity(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}