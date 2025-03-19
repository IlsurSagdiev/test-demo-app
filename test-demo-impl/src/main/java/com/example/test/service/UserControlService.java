package com.example.test.service;

import com.example.testdemoapi.dto.UserDto;

import java.util.List;

public interface UserControlService {

    UserDto update(UserDto dto);

    void deleteEmail(Long userId);

    void deletePhone(Long userId);

    List<UserDto> findAll();

    UserDto findById(Long id);
}