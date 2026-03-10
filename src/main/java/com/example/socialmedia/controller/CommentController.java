package com.example.socialmedia.controller;

import com.example.socialmedia.dto.CommentDto;
import com.example.socialmedia.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentDto createComment(
            @RequestParam Long userId,
            @RequestParam Long postId,
            @RequestParam String content
    ){
        return commentService.createComment(userId, postId, content);
    }

    @GetMapping("/post/{postId}")
    public List<CommentDto> getComments(@PathVariable Long postId){
        return commentService.getCommentsByPost(postId);
    }
}
