package com.netflixclone.authserviceAuthService.controller;

import com.netflixclone.authserviceAuthService.dto.LoginRequestDTO;
import com.netflixclone.authserviceAuthService.dto.LoginResponseDTO;
import com.netflixclone.authserviceAuthService.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request){
        LoginResponseDTO response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
