package br.com.api.aluguel.model;

import jakarta.persistence.*;

@Entity
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private PedidoEntity pedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private ContratoType tipo;

    @Column(name = "valor")
    private int valor;

    @Column(name = "credito")
    private boolean credito;

    @Column(name = "duration")
    private int duration;

    // Construtor padrão
    public ContratoEntity() {}

    // Construtor com parâmetros
    public ContratoEntity(PedidoEntity pedido, ContratoType tipo, int valor, boolean credito, int duration) {
        this.pedido = pedido;
        this.tipo = tipo;
        this.valor = valor;
        this.credito = credito;
        this.duration = duration;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContratoType getTipo() {
        return tipo;
    }

    public void setTipo(ContratoType tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isCredito() {
        return credito;
    }

    public void setCredito(boolean credito) {
        this.credito = credito;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}