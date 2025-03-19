package com.example.testdemoapi.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Данные пользователя без пароля")
public class UserDto {

    @ApiModelProperty(value = "Идентификатор пользователя", example = "1")
    private Long id;

    @ApiModelProperty(value = "Имя пользователя", example = "john_doe")
    private String username;

    @ApiModelProperty(value = "Email пользователя", example = "john.doe@example.com")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}