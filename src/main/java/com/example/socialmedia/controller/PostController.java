package com.example.socialmedia.controller;

import com.example.socialmedia.dto.CreatePostRequest;
import com.example.socialmedia.dto.PostDto;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post createPost(@RequestBody @Valid CreatePostRequest request){
        return postService.createPost(request.getUserId(), request.getContent());
    }

    @GetMapping
    public List<PostDto> getPosts(){
        return postService.getAllPosts();
    }
}
