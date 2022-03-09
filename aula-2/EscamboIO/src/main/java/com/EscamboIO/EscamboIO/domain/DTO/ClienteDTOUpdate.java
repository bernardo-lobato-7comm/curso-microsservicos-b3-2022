package com.EscamboIO.EscamboIO.domain.DTO;

import com.EscamboIO.EscamboIO.domain.Cliente;
import com.EscamboIO.EscamboIO.services.validation.ClienteUpdateValid;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@ClienteUpdateValid
public class ClienteDTOUpdate implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private String password;
    private String CPF;

    private Set<EnderecoDTO> enderecos = new HashSet<>();

    public ClienteDTOUpdate(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.CPF = obj.getCPF();
        obj.getEnderecos().forEach(x -> enderecos.add(new EnderecoDTO(x)));
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getCPF() {
        return CPF;
    }

    public Set<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
