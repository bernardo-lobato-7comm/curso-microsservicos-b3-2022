package com.EscamboIO.EscamboIO.domain.DTO;

import com.EscamboIO.EscamboIO.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter@Setter@NoArgsConstructor
public class ProdutoDTO implements Serializable {

    private Long id;
    private String nome;
    private Integer quantidadeEmStock;
    private Double preco;

    public ProdutoDTO(Produto obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.quantidadeEmStock = obj.getQuantidadeEmStock();
        this.preco = obj.getPreco();
    }
}
