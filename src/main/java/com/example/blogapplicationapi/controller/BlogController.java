package com.example.blogapplicationapi.controller;

import com.example.blogapplicationapi.entity.Blog;
import com.example.blogapplicationapi.entity.User;
import com.example.blogapplicationapi.service.BlogService;
import com.example.blogapplicationapi.utility.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/blogs/{userId}")
    public ResponseEntity<ResponseStructure<Blog>> insertBlog(@PathVariable String blogId, @RequestBody Blog blog){
        Blog savedBlog = blogService.insertBlog(blogId, blog);

        ResponseStructure<Blog> responseStructure = new ResponseStructure<Blog>();
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Blog object created successfully");
        responseStructure.setData(savedBlog);
        return new ResponseEntity<ResponseStructure<Blog>>(responseStructure, HttpStatus.CREATED);
    }

}
