package com.example.blogapplicationapi.controller;

import com.example.blogapplicationapi.entity.Blog;
import com.example.blogapplicationapi.dto.BlogPageResponse;
import com.example.blogapplicationapi.service.BlogService;
import com.example.blogapplicationapi.utility.ResponseStructure;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @PostMapping("/blogs")
    public ResponseEntity<ResponseStructure<Blog>> insertBlog(@RequestBody Blog blog) {
        Blog savedBlog = blogService.insertBlog(blog);

        ResponseStructure<Blog> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Blog created successfully");
        response.setData(savedBlog);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/blogs/{blogId}")
    public ResponseEntity<ResponseStructure<Blog>> getBlog(@PathVariable String blogId) {
        Blog foundBlog = blogService.findBlogById(blogId);

        ResponseStructure<Blog> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blog fetched successfully");
        responseStructure.setData(foundBlog);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @PutMapping("/blogs/{blogId}")
    public ResponseEntity<ResponseStructure<Blog>> updateBlog(@PathVariable String blogId, @RequestBody Blog blog) {
        Blog updatedBlog = blogService.updateBlogById(blogId, blog);

        ResponseStructure<Blog> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blog updated successfully");
        responseStructure.setData(updatedBlog);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<ResponseStructure<Blog>> deleteBlog(@PathVariable String blogId) {
        Blog deletedBlog = blogService.deleteBlogById(blogId);

        ResponseStructure<Blog> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blog deleted successfully");
        responseStructure.setData(deletedBlog);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<ResponseStructure<BlogPageResponse>> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<Blog> blogPage = blogService.findBlogs(page, size);

        BlogPageResponse blogPageResponse = new BlogPageResponse(
                blogPage.getNumber(),
                blogPage.getTotalPages(),
                blogPage.getTotalElements(),
                blogPage.getContent()
        );

        ResponseStructure<BlogPageResponse> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blogs fetched successfully");
        responseStructure.setData(blogPageResponse);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
    @GetMapping("/user/blogs")
    public ResponseEntity<ResponseStructure<BlogPageResponse>> findAllBlogsByUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Page<Blog> blogPage = blogService.findAllBlogsByUser(page, size);

        BlogPageResponse blogPageResponse = new BlogPageResponse(
                blogPage.getNumber(),
                blogPage.getTotalPages(),
                blogPage.getTotalElements(),
                blogPage.getContent()
        );

        ResponseStructure<BlogPageResponse> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Blogs fetched successfully");
        responseStructure.setData(blogPageResponse);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }


}
