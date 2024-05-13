package de.akza.jk.models;

import static de.akza.jk.models.Permission.*;

import lombok.Getter;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
public enum Role {
    ADMIN(Set.of(ADMIN_READ, ADMIN_UPDATE, ADMIN_DELETE, ADMIN_CREATE)),
    PLAYER(Set.of(PLAYER_READ, PLAYER_UPDATE, PLAYER_DELETE, PLAYER_CREATE));


    @Getter private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}