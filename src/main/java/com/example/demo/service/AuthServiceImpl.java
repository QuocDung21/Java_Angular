package com.example.demo.service;

import com.example.demo.dto.AuthDto;
import com.example.demo.emtity.Auth;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.AuthMapper;
import com.example.demo.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;

    @Override
    public AuthDto createAuth(AuthDto authDto) {
        Auth auth = AuthMapper.mapToAuth(authDto);
        Auth savedAuth = authRepository.save(auth);
        return AuthMapper.mapToAuthDto(savedAuth);
    }

    @Override
    public AuthDto getAuthById(Long authId) {
        Auth auth = authRepository
                .findById(authId)
                .orElseThrow(() -> new ResourceNotFoundException("Auth is not exist with id " + authId));
        return AuthMapper.mapToAuthDto(auth);
    }

    @Override
    public AuthDto deleteAuthById(Long authId) {
        Auth authToDelete = authRepository.findById(authId)
                .orElseThrow(() -> new ResourceNotFoundException("Auth is not exist with id " + authId));
        authRepository.deleteById(authId);

        return AuthMapper.mapToAuthDto(authToDelete);
    }


    @Override
    public List<AuthDto> getAllAuths() {
        List<Auth> auths = authRepository.findAll();
        return auths
                .stream()
                .map((AuthMapper::mapToAuthDto))
                .collect(Collectors.toList());
    }


}
