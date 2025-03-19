package com.example.testdemoapi.dto.email;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Запрос смены email")
public class EmailChangeDto {
    @ApiModelProperty(value = "старый email", example = "drevnii@mail.com")
    private String oldEmail;

    @ApiModelProperty(value = "новый email", example = "new@example.com")
    private String newEmail;

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}