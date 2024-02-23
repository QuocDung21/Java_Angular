package com.example.demo.service;
import com.example.demo.dto.AuthDto;
import com.example.demo.emtity.Auth;

import java.util.List;

public interface AuthService {
    AuthDto createAuth(AuthDto authDto);
    AuthDto getAuthById(Long authId);

    AuthDto deleteAuthById(Long authId);
    List<AuthDto> getAllAuths();
}
