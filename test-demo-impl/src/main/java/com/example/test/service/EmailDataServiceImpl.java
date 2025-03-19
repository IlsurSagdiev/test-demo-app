package com.example.test.service;

import com.example.test.persistence.EmailData;
import com.example.test.persistence.User;
import com.example.test.repository.EmailDataRepository;
import com.example.testdemoapi.dto.email.EmailAddDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmailDataServiceImpl implements EmailDataService {

    private final EmailDataRepository emailDataRepository;

    @Override
    @Transactional
    public void add(EmailAddDto emailAddDto) {
        if (!this.isValidEmail(emailAddDto.getEmail()) || emailDataRepository.findByEmail(newEmail) != null) {
            throw new RuntimeException("Email недоступен или некорректен");
        }

        var user = getUserById(userId);
        this.fillEmail(user, newEmail);

        return userRepository.save(user);
    }

    private void fillEmail(User user, String newEmail) {

        var emailData = new EmailData();
        emailData.setEmail(newEmail);
        emailData.setUser(user);

        Set<EmailData> emails = user.getEmails();
        if (CollectionUtils.isEmpty(emails)) {
            emails = new HashSet<>();
        }
        emails.add(emailData);
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.length() > 4;
    }
}
