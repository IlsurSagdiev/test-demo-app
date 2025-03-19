package com.example.testdemoapi.dto.email;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Ответ на смену email")
public class EmailChangeResponseDto extends EmailChangeDto {
    @ApiModelProperty(value = "Идентификатор пользователя", example = "1")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}