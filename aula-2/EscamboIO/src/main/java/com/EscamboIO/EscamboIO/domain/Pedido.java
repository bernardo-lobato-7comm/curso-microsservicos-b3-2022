package com.EscamboIO.EscamboIO.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco enderecoDeEntrega;

    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL )
    private Set<ItemPedido> items = new HashSet<>();

    public Pedido(Long id, Instant date, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.date = date;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Long getId() {
        return id;
    }

    public Set<ItemPedido> getItems() {
        return items;
    }

    public Instant getDate() {
        return date;
    }

    @JsonIgnore
    public Cliente getCliente() {
        return cliente;
    }


    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }
}
