package com.EscamboIO.EscamboIO.repositories;

import com.EscamboIO.EscamboIO.domain.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


   @Query("SELECT obj FROM Pedido obj WHERE " +
           "obj.cliente.email = :userEmail " +
           "ORDER BY obj.date DESC")
   Page<Pedido> find(String userEmail, Pageable pageable);
}
