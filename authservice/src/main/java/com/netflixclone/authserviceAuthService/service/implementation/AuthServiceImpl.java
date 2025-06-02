package com.netflixclone.authserviceAuthService.service.implementation;

import com.netflixclone.authserviceAuthService.dto.LoginRequestDTO;
import com.netflixclone.authserviceAuthService.dto.LoginResponseDTO;
import com.netflixclone.authserviceAuthService.entity.User;
import com.netflixclone.authserviceAuthService.repository.UserRepository;
import com.netflixclone.authserviceAuthService.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.netflixclone.authserviceAuthService.util.JwtUtil;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!BCrypt.checkpw(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new LoginResponseDTO(token);
    }
}
