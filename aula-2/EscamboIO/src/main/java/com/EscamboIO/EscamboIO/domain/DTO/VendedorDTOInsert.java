package com.EscamboIO.EscamboIO.domain.DTO;

import com.EscamboIO.EscamboIO.domain.Vendedor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor@Getter
public class VendedorDTOInsert implements Serializable {

    private Long id;
    @NotBlank(message = "Campo Nome não pode ficar em branco")
    private String nome;
    @NotBlank(message = "Campo E-Mail não pode ficar em branco")
    private String email;
    @NotBlank(message = "Campo Password não pode ficar em branco")
    private String password;
    @NotBlank(message = "Campo CNPJ não pode ficar em branco")
    private String CNPJ;
    private String empresa;
    private String siteComercial;

    private RoleDTO role;

    @NotEmpty(message = "É obrigatório colocar pelo menos 1 endereço")
    private Set<EnderecoDTO> enderecos = new HashSet<>();

    public VendedorDTOInsert(Vendedor obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.CNPJ = obj.getCNPJ();
        this.empresa = obj.getEmpresa();
        this.siteComercial = obj.getSiteComercial();
        this.role = new RoleDTO(obj.getRole());
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

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setSiteComercial(String siteComercial) {
        this.siteComercial = siteComercial;
    }
}
