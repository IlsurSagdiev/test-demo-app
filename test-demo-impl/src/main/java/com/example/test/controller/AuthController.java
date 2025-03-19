package com.example.test.controller;

import com.example.test.service.AuthService;
import com.example.testdemoapi.dto.AuthRequest;
import com.example.testdemoapi.resource.AuthResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthResource {

    private final AuthService authService;

    @Override
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        var token = authService.authenticate(authRequest.getIdentifier(), authRequest.getPassword());
        return ResponseEntity.ok(token);
    }
}
