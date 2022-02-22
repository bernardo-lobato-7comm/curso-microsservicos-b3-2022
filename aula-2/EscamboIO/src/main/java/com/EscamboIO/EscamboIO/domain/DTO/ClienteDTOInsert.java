package com.EscamboIO.EscamboIO.domain.DTO;

import com.EscamboIO.EscamboIO.domain.Cliente;
import com.EscamboIO.EscamboIO.services.validation.ClienteInsertValid;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor@Getter
@ClienteInsertValid
public class ClienteDTOInsert implements Serializable {

    private Long id;
    @NotBlank(message = "Campo Nome não pode ficar em branco")
    private String nome;
    @NotBlank(message = "Campo E-Mail não pode ficar em branco")
    private String email;
    @NotBlank(message = "Campo Senha não pode ficar em branco")
    private String password;
    @NotBlank(message = "Campo Cpf não pode ficar em branco")
    private String CPF;

    private RoleDTO role;

    @NotEmpty(message = "É obrigatório colocar pelo menos 1 endereço")
    private Set<EnderecoDTO> enderecos = new HashSet<>();

    public ClienteDTOInsert(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.CPF = obj.getCPF();
        this.role = new RoleDTO(obj.getRole());
        obj.getEnderecos().forEach(x -> enderecos.add(new EnderecoDTO(x)));
    }

    public void setId(Long id) {
        this.id = id;
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
