package com.example.demo.mapper;

import com.example.demo.dto.AuthDto;
import com.example.demo.emtity.Auth;

public class AuthMapper {

    public static AuthDto mapToAuthDto(Auth auth) {
        return new AuthDto(
                auth.getId(),
                auth.getUsername(),
                auth.getPassword()
        );
    }

    public static Auth mapToAuth(AuthDto authDto) {
        return new Auth(
                authDto.getId(),
                authDto.getUsername(),
                authDto.getPassword()
        );
    }
}
