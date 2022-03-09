package com.EscamboIO.EscamboIO.repositories;

import com.EscamboIO.EscamboIO.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT obj FROM Produto obj WHERE " +
            "obj.vendedor.email = :name " +
            "ORDER BY obj.nome DESC")
    Page<Produto> findAllByVendedor(Pageable pageable, String name);
}
