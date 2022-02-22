package com.EscamboIO.EscamboIO.domain.DTO;

import com.EscamboIO.EscamboIO.domain.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor@Getter@Setter
public class EnderecoDTO implements Serializable {

    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;

    public EnderecoDTO(Endereco obj) {
        this.id = obj.getId();
        this.logradouro = obj.getLogradouro();
        this.numero = obj.getNumero();
        this.bairro = obj.getBairro();
        this.cep = obj.getCep();
    }
}
