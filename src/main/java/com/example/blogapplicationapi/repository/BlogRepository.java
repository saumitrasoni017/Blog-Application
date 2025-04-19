package com.example.blogapplicationapi.repository;

import com.example.blogapplicationapi.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, String> {
}
