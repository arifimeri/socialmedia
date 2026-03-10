package com.example.socialmedia.controller;

import com.example.socialmedia.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/follow")
    public String follow(@RequestParam Long followerId, @RequestParam Long followingId){
        followService.followUser(followerId, followingId);
        return "Followed successfully";
    }

    @PostMapping("/unfollow")
    public String unfollow(@RequestParam Long followerId, @RequestParam Long followingId){
        followService.unfollowUser(followerId, followingId);
        return "Unfollowed successfully";
    }
}
