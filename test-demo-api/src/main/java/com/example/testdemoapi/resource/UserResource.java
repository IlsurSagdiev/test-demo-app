package com.example.testdemoapi.resource;

import com.example.testdemoapi.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Управление пользователями")
public interface UserResource {

    @GetMapping
    @ApiOperation(value = "Получить всех пользователей", response = List.class)
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить пользователя по ID", response = UserDto.class)
    ResponseEntity<UserDto> getUserById(@PathVariable Long id);

    @PutMapping("/{id}")
    @ApiOperation(value = "Обновить существующего пользователя", response = UserDto.class)
    ResponseEntity<UserDto> updateUser(@RequestBody UserDto user);

}
