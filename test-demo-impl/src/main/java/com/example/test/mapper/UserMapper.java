package com.example.test.mapper;

import com.example.test.persistence.User;
import com.example.testdemoapi.dto.UserDto;

public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}