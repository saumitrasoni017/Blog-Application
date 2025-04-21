package com.example.blogapplicationapi.dto;

import com.example.blogapplicationapi.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogPageResponse {
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private List<Blog> blogs;
}
