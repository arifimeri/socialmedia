package com.example.socialmedia.mapper;

import com.example.socialmedia.dto.CommentDto;
import com.example.socialmedia.entity.Comment;

public class CommentMapper {

    public static CommentDto toDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .username(comment.getUser().getUsername())
                .postId(comment.getPost().getId())
                .build();
    }
}
