package com.example.testdemoapi.dto.email;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Запрос удаления email")
public class EmailDeleteDto {

    @ApiModelProperty(value = "Идентификатор пользователя", example = "1")
    private Long id;

    @ApiModelProperty(value = "email", example = "new@example.com")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}