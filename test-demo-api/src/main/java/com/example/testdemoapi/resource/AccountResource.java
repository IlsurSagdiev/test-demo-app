package com.example.testdemoapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public interface AccountResource {

    @GetMapping("/{id}")
    public String getAccount(@PathVariable String id);
}
