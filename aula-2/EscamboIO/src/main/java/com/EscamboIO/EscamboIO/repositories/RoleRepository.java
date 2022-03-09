package com.EscamboIO.EscamboIO.repositories;

import com.EscamboIO.EscamboIO.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
