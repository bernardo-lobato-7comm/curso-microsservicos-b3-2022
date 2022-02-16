package com.EscamboIO.EscamboIO.services;

import com.EscamboIO.EscamboIO.domain.Cliente;
import com.EscamboIO.EscamboIO.domain.Vendedor;
import com.EscamboIO.EscamboIO.repositories.ClienteRepository;
import com.EscamboIO.EscamboIO.repositories.VendedorRepository;
import com.EscamboIO.EscamboIO.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;


    public String authenticatedCliente(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Cliente cliente = clienteRepository.findByEmail(username);
            if(cliente == null){
                throw  new UnauthorizedException("Essa conta não tem permissão para esse recurso");
            }else{
                return username;
            }
        }
        catch (Exception e){
            throw new UnauthorizedException("Essa conta não tem permissão para esse recurso");
        }
    }

    public String authenticatedVendedor(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Vendedor vendedor = vendedorRepository.findByEmail(username);
            if(vendedor == null){
                throw  new UnauthorizedException("Essa conta não tem permissão para esse recurso");
            }else{
                return username;
            }
        }
        catch (Exception e){
            throw new UnauthorizedException("Essa conta não tem permissão para esse recurso");
        }
    }


    public String authenticatedAll(){
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            Cliente cliente = clienteRepository.findByEmail(username);
            if(cliente == null){
                Vendedor vendedor = vendedorRepository.findByEmail(username);
                if(vendedor == null){
                    throw new EntityNotFoundException("Usuário não encontrado");
                }
            }else{
                return username;
            }
        }
        catch (Exception e){
            throw new UnauthorizedException("Essa conta não tem permissão para esse recurso");
        }
        return null;
    }
}
