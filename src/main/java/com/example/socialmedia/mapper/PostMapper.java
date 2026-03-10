package com.example.socialmedia.mapper;

import com.example.socialmedia.dto.PostDto;
import com.example.socialmedia.entity.Post;

public class PostMapper {

    public static PostDto toDto(Post post){

        return PostDto.builder()
                .id(post.getId())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .username(post.getUser().getUsername())
                .build();
    }
}
