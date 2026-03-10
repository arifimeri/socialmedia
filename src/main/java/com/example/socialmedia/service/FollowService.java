package com.example.socialmedia.service;

import com.example.socialmedia.entity.User;
import com.example.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final UserRepository userRepository;


    public void followUser(Long followerId, Long followingId){
        if(followerId.equals(followingId)){
            throw new RuntimeException("User cannot follow themselves");
        }

        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following user not found"));

        if(follower.getFollowing().contains(following)){
            throw new RuntimeException("Already following this user");
        }

        follower.getFollowing().add(following);
        userRepository.save(follower);
    }

    public void unfollowUser(Long followerId, Long followingId){
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower not found"));

        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following user not found"));

        follower.getFollowing().remove(following);
        userRepository.save(follower);
    }
}
