package br.com.api.aluguel.model;

import jakarta.persistence.*;

@Entity
public class AgenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome")
    private String nome;

    @Column(name = "banco")
    private Boolean banco;

    public AgenteEntity(){}

    public AgenteEntity(UserEntity user, String nome, Boolean banco){
        this.user = user;
        this.nome = nome;
        this.banco = banco;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getBanco(){
        return banco;
    }

    public void setBanco(Boolean banco) {
        this.banco = banco;
    }

}