package com.example.test.service;

import com.example.test.persistence.User;
import com.example.test.repository.UserRepository;
import com.example.test.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String authenticate(String identifier, String password) {
        User user;

        if (isEmail(identifier)) {
            user = userRepository.findByEmail(identifier)
                    .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким email не найден. email = " + identifier));
        } else {
            user = userRepository.findByPhone(identifier)
                    .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким телефоном не найден. phone = " + identifier));
        }

        // Проверяем, существует ли пользователь и совпадают ли пароли
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getId());
        } else {
            throw new RuntimeException("Неверные учетные данные");
        }
    }

    private boolean isEmail(String identifier) {
        return identifier != null && identifier.contains("@") && identifier.length() > 4;
    }
}