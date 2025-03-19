package com.example.testdemoapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phone")
public interface PhoneDataResource {

    @GetMapping("/{id}")
    public String getPhoneData(@PathVariable String id);
}
