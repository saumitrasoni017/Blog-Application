package com.example.blogapplicationapi.service;

import com.example.blogapplicationapi.entity.Blog;

public interface BlogService {
    public Blog insertBlog(String userId, Blog blogRequest);
}
