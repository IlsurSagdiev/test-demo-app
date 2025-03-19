package com.example.testdemoapi.resource;

import com.example.testdemoapi.dto.email.EmailAddDto;
import com.example.testdemoapi.dto.email.EmailChangeDto;
import com.example.testdemoapi.dto.email.EmailChangeResponseDto;
import com.example.testdemoapi.dto.email.EmailDeleteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public interface EmailDataResource {
    @PostMapping("/{userId}")
    ResponseEntity<EmailChangeResponseDto> changeEmail(@PathVariable String userId, @RequestBody EmailChangeDto emailChangeRequest);

    @DeleteMapping("/delete")
    ResponseEntity<Void> delete(@RequestBody EmailDeleteDto emailDeleteDto);

    @PostMapping("/add")
    ResponseEntity<Void> add(@RequestBody EmailAddDto emailAddDto);
}
