package com.netflixclone.userservice.service.impl;

import com.netflixclone.userservice.dto.UserDTO;
import com.netflixclone.userservice.dto.UserRequestDTO;
import com.netflixclone.userservice.entity.User;
import com.netflixclone.userservice.repository.UserRepository;
import com.netflixclone.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserRequestDTO userRequest){
        if(userRepository.existsByEmail(userRequest.getEmail())){
            throw new RuntimeException("Email already in use");
        }

        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();

        User savedUser = userRepository.save(user);
        return toDTO(savedUser);
    }

    @Override
    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByID(Long id){
        return userRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateUser(String email, User updatedUser) {
        User existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());

        // If password is not null or empty, re-has and update it
        if(updatedUser.getPassword() != null && !updatedUser.getPassword().isBlank()){
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        }

        User savedUser = userRepository.save(existingUser);
        return toDTO(savedUser);
    }

    private UserDTO toDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
