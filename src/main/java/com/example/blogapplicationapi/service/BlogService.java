package com.example.blogapplicationapi.service;

import com.example.blogapplicationapi.entity.Blog;
import org.springframework.data.domain.Page;

public interface BlogService {
    public Blog insertBlog(Blog blog);
    public Blog findBlogById(String blogId);
    public Blog updateBlogById(String blogId, Blog updatedBlog);
    public Blog deleteBlogById(String blogId);
    public Page<Blog> findBlogs(int page, int size);

    Page<Blog> findAllBlogsByUser(int page, int size);
}
