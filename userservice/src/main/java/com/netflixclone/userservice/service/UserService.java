package com.netflixclone.userservice.service;

import com.netflixclone.userservice.dto.UserDTO;
import com.netflixclone.userservice.dto.UserRequestDTO;
import com.netflixclone.userservice.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserRequestDTO userRequest);
    List<UserDTO> getAllUsers();
    UserDTO getUserByID(Long id);
    void deleteUser(Long id);
    UserDTO updateUser(String email, User updatedUser);

}
