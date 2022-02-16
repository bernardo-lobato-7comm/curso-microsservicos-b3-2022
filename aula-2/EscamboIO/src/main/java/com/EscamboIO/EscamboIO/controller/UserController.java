package com.EscamboIO.EscamboIO.controller;

import com.EscamboIO.EscamboIO.domain.DTO.ClienteDTOInsert;
import com.EscamboIO.EscamboIO.domain.DTO.ClienteDTOUpdate;
import com.EscamboIO.EscamboIO.domain.DTO.ProdutoDTO;
import com.EscamboIO.EscamboIO.domain.DTO.VendedorDTOInsert;
import com.EscamboIO.EscamboIO.domain.Pedido;
import com.EscamboIO.EscamboIO.services.PedidoService;
import com.EscamboIO.EscamboIO.services.ProdutoService;
import com.EscamboIO.EscamboIO.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProdutoService produtoService;


    @PostMapping(value = "/criar/cliente")
    public ResponseEntity<ClienteDTOInsert> criarUsuario(@Valid @RequestBody ClienteDTOInsert obj){
      ClienteDTOInsert user = service.criarUsuarioComprador(obj);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
      return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/criar/vendedor")
    public ResponseEntity<VendedorDTOInsert> criarVendedor(@Valid @RequestBody VendedorDTOInsert obj){
        VendedorDTOInsert user = service.criarUsuarioVendedor(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/pedidos")
    public ResponseEntity<Page<Pedido>> pedidos(Pageable pageable){
        Page<Pedido> page = pedidoService.pedidosDoUsuarioLogado(pageable);
        return ResponseEntity.ok().body(page);
    }

    @DeleteMapping(value = "/pedidos/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
       pedidoService.deletarPedido(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<ClienteDTOUpdate> alteraUsuario(@Valid @RequestBody ClienteDTOUpdate obj){
        service.alteraUsuario(obj);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/produtos")
    public ResponseEntity<Page<ProdutoDTO>> vendedorProdutos(Pageable pageable){
        Page<ProdutoDTO> produtos = produtoService.vendedorProdutos(pageable);
        return ResponseEntity.ok().body(produtos);
    }

    @PutMapping(value = "/produto/{id}")
    public ResponseEntity<ProdutoDTO> alterarPrecoProduto(@PathVariable Long id, @RequestBody ProdutoDTO obj){
        produtoService.alterarPrecoProduto(id, obj);
        return ResponseEntity.ok().build();
    }
}
