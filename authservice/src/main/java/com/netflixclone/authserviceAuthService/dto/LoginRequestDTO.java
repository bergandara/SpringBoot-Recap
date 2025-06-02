package com.netflixclone.authserviceAuthService.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String password;
    private String email;
}
