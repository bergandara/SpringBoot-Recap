package com.netflixclone.userservice.controller;

import com.netflixclone.userservice.dto.UserDTO;
import com.netflixclone.userservice.entity.User;
import com.netflixclone.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user){
        UserDTO createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserByID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

//@RestController tells Spring to return JSON instead of rendering a view.
//
//@RequestMapping("/api/users") sets the base URL for all endpoints.
//
//@PostMapping, @GetMapping, @DeleteMapping map to HTTP methods.
//
//@RequestBody binds a JSON payload to a Java object.
//
//@PathVariable extracts id from the URL.