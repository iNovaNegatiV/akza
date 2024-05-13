package de.akza.jk.Dtos;

import de.akza.jk.models.Role;
import lombok.Data;

@Data
public class GetUserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Role role;
}
