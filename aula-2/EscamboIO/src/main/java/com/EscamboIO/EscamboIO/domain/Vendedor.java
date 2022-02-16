package com.EscamboIO.EscamboIO.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Getter@NoArgsConstructor
@Entity
@Table(name = "tb_vendedores")
public class Vendedor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;
    private String empresa;
    private String siteComercial;
    private String CNPJ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "vendedor")
    private Set<Produto> produtos = new HashSet<>();


    public Vendedor(Long id, String nome, String email, String password, String empresa, String siteComercial, String CNPJ, Role role) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.empresa = empresa;
        this.siteComercial = siteComercial;
        this.CNPJ = CNPJ;
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setSiteComercial(String siteComercial) {
        this.siteComercial = siteComercial;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<String> roles = List.of(role.getAuthority());
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
