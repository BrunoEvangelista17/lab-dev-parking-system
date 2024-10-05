package br.com.api.aluguel.model;

import jakarta.persistence.*;

@Entity
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private int valor; // Novo atributo valor

    // Construtor padrão
    public Investimento() {}

    // Construtor com parâmetros
    public Investimento(String nome, int valor) {
        this.nome = nome;
        this.valor = valor; // Inicializando valor no construtor
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
