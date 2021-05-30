package com.tracking.system.models.dtos.auth;

public record SignInRequest(
        String username,
        String password
) {
}
