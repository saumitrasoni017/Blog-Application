package com.example.blogapplicationapi.service.impl;

import com.example.blogapplicationapi.entity.Blog;
import com.example.blogapplicationapi.entity.User;
import com.example.blogapplicationapi.exception.BlogNotFoundException;
import com.example.blogapplicationapi.exception.UserNotFoundException;
import com.example.blogapplicationapi.repository.BlogRepository;
import com.example.blogapplicationapi.repository.UserRepository;
import com.example.blogapplicationapi.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    @Override
    public Blog insertBlog(Blog blog) {
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new UserNotFoundException("User not found with email"));

        blog.setUser(user);

        return blogRepository.save(blog);
    }

    @Override
    public Blog findBlogById(String blogId) {
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found"));
    }

    @Override
    public Blog updateBlogById(String blogId, Blog updatedBlog) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found"));

        blog.setTitle(updatedBlog.getTitle());
        blog.setContent(updatedBlog.getContent());
        blog.setUpdatedAt(LocalDate.now());

        return blogRepository.save(blog);
    }

    @Override
    public Blog deleteBlogById(String blogId) {
        Blog blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found"));

        blogRepository.delete(blog);
        return blog;
    }

    @Override
    public Page<Blog> findBlogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> blogs = blogRepository.findAll(pageable);

        if (blogs.isEmpty()) {
            throw new BlogNotFoundException("No blogs found on page " + page);
        }

        return blogs;
    }

    @Override
    public Page<Blog> findAllBlogsByUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Page<Blog> blogs = blogRepository.findAllByUserEmail(email,pageable);

        if (blogs.isEmpty()) {
            throw new BlogNotFoundException("No blogs found on page " + page);
        }

        return blogs;
    }


}
