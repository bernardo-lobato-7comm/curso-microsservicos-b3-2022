package com.EscamboIO.EscamboIO.services;

import com.EscamboIO.EscamboIO.domain.DTO.ProdutoDTO;
import com.EscamboIO.EscamboIO.domain.Produto;
import com.EscamboIO.EscamboIO.repositories.ProdutoRepository;
import com.EscamboIO.EscamboIO.repositories.VendedorRepository;
import com.EscamboIO.EscamboIO.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    @Autowired
    private AuthService authService;


    public Page<ProdutoDTO> vendedorProdutos(Pageable pageable){
        String username = authService.authenticatedVendedor();
        Page<Produto> produtos = repository.findAllByVendedor(pageable, username);
        return produtos.map(x -> new ProdutoDTO(x));
    }

    public ProdutoDTO alterarPrecoProduto(Long id, ProdutoDTO produtoDTO){
        Produto produto = repository.getById(id);
        String username = authService.authenticatedVendedor();
        if(produto.getVendedor().getEmail().equals(username)){
            produto.setPreco(produtoDTO.getPreco());
            produto = repository.save(produto);
            return new ProdutoDTO(produto);
        }
        else{
            throw new UnauthorizedException("Você não pode alterar o preço de um produto que não é seu");
        }
    }
}
