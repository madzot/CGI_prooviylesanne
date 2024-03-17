package com.cgi.controller;

import com.cgi.dtos.LoginDto;
import com.cgi.dtos.RegistrationDto;
import com.cgi.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PutMapping(path = "/api/account")
    public ResponseEntity<String> login(@RequestBody LoginDto data) {
        return null;
    }
}
