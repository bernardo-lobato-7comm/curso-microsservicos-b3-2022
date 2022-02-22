package com.EscamboIO.EscamboIO.repositories;

import com.EscamboIO.EscamboIO.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
