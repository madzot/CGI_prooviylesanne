package com.cgi.controller;

import com.cgi.dtos.LoginDto;
import com.cgi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AccountController {
    @PutMapping(path = "/api/account")
    public ResponseEntity<String> login(@RequestBody LoginDto data) {
        return null;
    }
}
