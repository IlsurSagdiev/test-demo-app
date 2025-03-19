package com.example.test.service;

import com.example.test.exception.UserNotFoundException;
import com.example.test.mapper.UserMapper;
import com.example.test.persistence.EmailData;
import com.example.test.persistence.User;
import com.example.test.repository.UserRepository;
import com.example.testdemoapi.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserControlServiceImpl implements UserControlService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User updatePhone(Long userId, String newPhone) {
        if (userRepository.findByPhone(newPhone) != null) {
            throw new RuntimeException("Телефон недоступен");
        }

        User user = this.getUserById(userId);
        user.setPhone(newPhone);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDto update(UserDto userDto) {
        var user = userMapper.userDtoToUser(userDto);
        return userMapper.userToUserDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteEmail(Long userId) {
        User user = getUserById(userId);
        user.setEmail(null); // Или можно использовать user.setEmail("") для очистки
        userRepository.save(user);
    }

    @Override
    public void deletePhone(Long userId) {
        User user = getUserById(userId);
        user.setPhone(null); // Или можно использовать user.setPhone("") для очистки
        userRepository.save(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
        return userMapper.userToUserDto(user);
    }

    private User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));
    }

}
