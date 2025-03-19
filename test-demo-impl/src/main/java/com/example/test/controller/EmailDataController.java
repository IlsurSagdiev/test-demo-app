package com.example.test.controller;

import com.example.test.service.EmailDataService;
import com.example.testdemoapi.dto.email.EmailAddDto;
import com.example.testdemoapi.dto.email.EmailChangeDto;
import com.example.testdemoapi.dto.email.EmailChangeResponseDto;
import com.example.testdemoapi.dto.email.EmailDeleteDto;
import com.example.testdemoapi.resource.EmailDataResource;
import org.springframework.http.ResponseEntity;

public class EmailDataController implements EmailDataResource {

    private final EmailDataService emailDataService;
    @Override
    public ResponseEntity<EmailChangeResponseDto> changeEmail(String userId, EmailChangeDto emailChangeRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(EmailDeleteDto emailDeleteDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> add(EmailAddDto emailAddDto) {
       emailDataService.add(emailAddDto);
    }
}
