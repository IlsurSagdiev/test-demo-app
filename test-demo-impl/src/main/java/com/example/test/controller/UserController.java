package com.example.test.controller;

import com.example.test.service.UserControlService;
import com.example.testdemoapi.dto.UserDto;
import com.example.testdemoapi.resource.UserResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserResource {
    private final UserControlService userService;

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto) {
        var updatedUser = userService.update(userDto);
        return ResponseEntity.ok(updatedUser);
    }
}