package com.example.socialmedia.controller;

import com.example.socialmedia.dto.CreateUserRequest;
import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody @Valid CreateUserRequest request){
        return userService.createUser(request);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }
}
