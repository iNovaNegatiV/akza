package de.akza.jk.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    PLAYER_READ("player:read"),
    PLAYER_UPDATE("player:update"),
    PLAYER_CREATE("player:create"),
    PLAYER_DELETE("player:delete");

    private final String permission;
}
