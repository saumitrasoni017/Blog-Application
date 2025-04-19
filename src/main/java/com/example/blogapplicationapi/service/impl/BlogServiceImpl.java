package com.example.blogapplicationapi.service.impl;

import com.example.blogapplicationapi.entity.Blog;
import com.example.blogapplicationapi.entity.User;
import com.example.blogapplicationapi.exception.UserNotFoundException;
import com.example.blogapplicationapi.repository.BlogRepository;
import com.example.blogapplicationapi.repository.UserRepository;
import com.example.blogapplicationapi.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    @Override
    public Blog insertBlog(String userId, Blog blogRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Blog blog = new Blog();
        blog.setTitle(blogRequest.getTitle());
        blog.setBlogStatus(blogRequest.getBlogStatus());
        blog.setCreatedAt(blogRequest.getCreatedAt());
        blog.setUpdatedAt(blogRequest.getUpdatedAt());
        blog.setUser(user);

        return blogRepository.save(blog);
    }
}
