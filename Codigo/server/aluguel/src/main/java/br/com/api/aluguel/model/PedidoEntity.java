package br.com.api.aluguel.model;

import jakarta.persistence.*;

@Entity
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "agente_id", referencedColumnName = "id")
    private AgenteEntity agente;

    @OneToOne
    @JoinColumn(name = "veiculo_id", referencedColumnName = "id")
    private VeiculoEntity veiculo;

    @Column(name = "aprovado")
    private boolean aprovado;

    @Column(name = "descricao")
    private String desc;

    @Column(name = "valor")
    private int valor;

    @Column(name = "duration")
    private int duration;

    // Construtor padrão
    public PedidoEntity() {}

    // Construtor com parâmetros
    public PedidoEntity(AgenteEntity agente, ClienteEntity cliente, VeiculoEntity veiculo, boolean aprovado, String desc, int valor, int duration) {
        this.agente = agente;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.aprovado = aprovado;
        this.desc = desc;
        this.valor = valor;
        this.duration = duration;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}