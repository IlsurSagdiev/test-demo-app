package com.example.testdemoapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Запрос на аутентификацию пользователя")
public class AuthRequest {

    @Schema(description = "Email или телефон пользователя", example = "user@example.com")
    private String identifier;

    @Schema(description = "Пароль пользователя", example = "password123")
    private String password;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}