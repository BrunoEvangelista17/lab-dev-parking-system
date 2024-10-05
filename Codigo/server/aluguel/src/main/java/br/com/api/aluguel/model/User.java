package br.com.api.aluguel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"User\"")  // Nome da tabela com aspas duplas para manter a maiúscula
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "senha")
    private String senha;

    // Construtor padrão
    public User(){}

    // Construtor com parâmetros
    public User(String login, String senha){
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