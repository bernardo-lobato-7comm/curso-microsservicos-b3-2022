package com.EscamboIO.EscamboIO.services;

import com.EscamboIO.EscamboIO.domain.Pedido;
import com.EscamboIO.EscamboIO.repositories.PedidoRepository;
import com.EscamboIO.EscamboIO.services.exceptions.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private AuthService authService;


    public Page<Pedido> pedidosDoUsuarioLogado(Pageable pageable){
        String username = authService.authenticatedCliente();
        Page<Pedido> pedidos = repository.find(username,pageable);
        return pedidos;
    }

    public void deletarPedido(Long id){
        Pedido pedido = repository.getById(id);
        String username = authService.authenticatedCliente();
        if(pedido.getCliente().getEmail().equals(username)){
             repository.delete(pedido);
        }
        else{
            throw new UnauthorizedException("Não tem permissão para deletar esse pedido");
        }
    }
}
