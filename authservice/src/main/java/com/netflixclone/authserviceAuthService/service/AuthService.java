package com.netflixclone.authserviceAuthService.service;

import com.netflixclone.authserviceAuthService.dto.LoginRequestDTO;
import com.netflixclone.authserviceAuthService.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO request);
}
