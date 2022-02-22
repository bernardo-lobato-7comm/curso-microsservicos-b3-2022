package com.EscamboIO.EscamboIO.repositories;

import com.EscamboIO.EscamboIO.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    Vendedor findByEmail(String s);
}
