package com.example.socialmedia.service;

import com.example.socialmedia.dto.CreateUserRequest;
import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.mapper.UserMapper;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDto createUser(CreateUserRequest request){
       User user  = User.builder()
               .username(request.getUsername())
               .email(request.getEmail())
               .password(request.getPassword())
               .build();

       User savedUser = repository.save(user);

       return UserMapper.toDto(savedUser);
    }

    public List<UserDto> getAllUsers(){
        return repository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }
}
