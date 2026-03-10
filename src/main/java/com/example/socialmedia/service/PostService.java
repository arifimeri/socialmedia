package com.example.socialmedia.service;

import com.example.socialmedia.dto.PostDto;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.User;
import com.example.socialmedia.mapper.PostMapper;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(Long userId, String content){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = Post.builder()
                .content(content)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        return postRepository.save(post);
    }

    public List<PostDto> getAllPosts(){
        return postRepository.findAll()
                .stream()
                .map(PostMapper::toDto)
                .toList();
    }
}
