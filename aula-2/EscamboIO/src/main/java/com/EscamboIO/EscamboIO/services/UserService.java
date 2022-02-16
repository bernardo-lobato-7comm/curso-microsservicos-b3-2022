package com.EscamboIO.EscamboIO.services;

import com.EscamboIO.EscamboIO.domain.Cliente;
import com.EscamboIO.EscamboIO.domain.DTO.ClienteDTOInsert;
import com.EscamboIO.EscamboIO.domain.DTO.ClienteDTOUpdate;
import com.EscamboIO.EscamboIO.domain.DTO.EnderecoDTO;
import com.EscamboIO.EscamboIO.domain.DTO.VendedorDTOInsert;
import com.EscamboIO.EscamboIO.domain.Endereco;
import com.EscamboIO.EscamboIO.domain.Vendedor;
import com.EscamboIO.EscamboIO.repositories.ClienteRepository;
import com.EscamboIO.EscamboIO.repositories.EnderecoRepository;
import com.EscamboIO.EscamboIO.repositories.RoleRepository;
import com.EscamboIO.EscamboIO.repositories.VendedorRepository;
import com.EscamboIO.EscamboIO.services.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthService authService;


    public ClienteDTOInsert criarUsuarioComprador(ClienteDTOInsert obj) {
        Cliente user = new Cliente();
        fromDTOInsert(user, obj);
        user.setPassword(bCryptPasswordEncoder.encode(obj.getPassword()));
        user = clienteRepository.save(user);
        enderecoRepository.saveAll(user.getEnderecos());
        return new ClienteDTOInsert(user);
    }

    public VendedorDTOInsert criarUsuarioVendedor(VendedorDTOInsert obj) {
        Vendedor user = new Vendedor();
        fromDTOInsert(user, obj);
        user.setPassword(bCryptPasswordEncoder.encode(obj.getPassword()));
        user = vendedorRepository.save(user);
        return new VendedorDTOInsert(user);
    }

    public ClienteDTOUpdate alteraUsuario(ClienteDTOUpdate obj) {
        try {
            String username = authService.authenticatedAll();
            Cliente cliente = clienteRepository.findByEmail(username);
            fromDTOUpdate(cliente, obj);
            cliente = clienteRepository.save(cliente);
            if (!obj.getEnderecos().isEmpty()) {
                enderecoRepository.saveAll(cliente.getEnderecos());
            }
            return new ClienteDTOUpdate(cliente);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Usuário não encontrado");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(s);
        if (cliente == null) {
            Vendedor vendedor = vendedorRepository.findByEmail(s);
            if (vendedor == null) {
                throw new UsernameNotFoundException("Usuario não encontrado");
            }
            log.info("Usuário encontrado = " + s);
            return vendedor;
        }
        log.info("Usuário encontrado = " + s);
        return cliente;
    }


    public void fromDTOInsert(Cliente user, ClienteDTOInsert dto) {
        user.setEmail(dto.getEmail());
        user.setNome(dto.getNome());
        user.setCPF(dto.getCPF());
        user.setRole(roleRepository.getById(1L));
        for (EnderecoDTO e : dto.getEnderecos()) {
            user.getEnderecos().add(new Endereco(null, e.getLogradouro(), e.getNumero(), e.getBairro(), e.getCep(),
                    user));
        }
    }

    public void fromDTOInsert(Vendedor user, VendedorDTOInsert dto) {
        user.setEmail(dto.getEmail());
        user.setNome(dto.getNome());
        user.setCNPJ(dto.getCNPJ());
        user.setEmpresa(dto.getEmpresa());
        user.setSiteComercial(dto.getSiteComercial());
        user.setRole(roleRepository.getById(1L));
    }

    public void fromDTOUpdate(Cliente user, ClienteDTOUpdate dto) {
        user.setCPF(dto.getCPF() != null ? dto.getCPF() : user.getCPF());
        user.setEmail(dto.getEmail() != null ? dto.getEmail() : user.getEmail());
        user.setNome(dto.getNome() != null ? dto.getNome() : user.getNome());
    }
}


