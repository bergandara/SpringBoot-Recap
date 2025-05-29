package com.netflixclone.userservice.service;

import com.netflixclone.userservice.dto.UserDTO;
import com.netflixclone.userservice.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(User user);
    List<UserDTO> getAllUsers();
    UserDTO getUserByID(Long id);
    void deleteUser(Long id);

}
