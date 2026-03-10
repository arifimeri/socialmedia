package com.example.socialmedia.service;

import com.example.socialmedia.dto.CommentDto;
import com.example.socialmedia.entity.Comment;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.mapper.CommentMapper;
import com.example.socialmedia.repository.CommentRepository;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentDto createComment(Long userId, Long postId, String content){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("user not found"));

        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new RuntimeException("post not found"));

        Comment comment = Comment.builder()
                .content(content)
                .createdAt(LocalDateTime.now())
                .user(user)
                .post(post)
                .build();

        return CommentMapper.toDto(commentRepository.save(comment));
    }

    public List<CommentDto> getCommentsByPost(Long postId){
        return commentRepository.findByPostId(postId)
                .stream()
                .map(CommentMapper::toDto)
                .toList();
    }
}
