package com.example.demo.controller;

import com.example.demo.dto.AuthDto;
import com.example.demo.emtity.Auth;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.AuthMapper;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("")
    public ResponseEntity<List<AuthDto>> getAllAuth() {
        List<AuthDto> auths = authService.getAllAuths();
        return ResponseEntity.ok(auths);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthDto> deleteAuthById(@PathVariable Long id) {
        AuthDto authDto = authService.deleteAuthById(id);
        return new ResponseEntity<>(authDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AuthDto> createAuth(@RequestBody AuthDto authDto) {
        AuthDto savedAuth = authService.createAuth(authDto);
        return new ResponseEntity<>(savedAuth, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthDto> getAuthById(@PathVariable Long id) {
        AuthDto authDto = authService.getAuthById(id);
        return new ResponseEntity<>(authDto, HttpStatus.OK);
    }




}

