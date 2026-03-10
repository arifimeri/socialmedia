package com.example.socialmedia.mapper;

import com.example.socialmedia.dto.UserDto;
import com.example.socialmedia.entity.User;

public class UserMapper {

    public static UserDto toDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
