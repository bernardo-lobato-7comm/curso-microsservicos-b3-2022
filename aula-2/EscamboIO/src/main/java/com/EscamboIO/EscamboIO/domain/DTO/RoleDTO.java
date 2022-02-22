package com.EscamboIO.EscamboIO.domain.DTO;

import com.EscamboIO.EscamboIO.domain.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor@Getter@Setter
public class RoleDTO implements Serializable {

    private Long id;
    private String authority;

    public RoleDTO(Role obj) {
        this.id = obj.getId();
        this.authority = obj.getAuthority();
    }
}
