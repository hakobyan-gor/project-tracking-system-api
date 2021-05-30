package com.tracking.system.models.dtos.auth;

public record AuthTokenDTO(
        String token,
        String roleName
) {
}
