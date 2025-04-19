package com.example.blogapplicationapi.entity;

import com.example.blogapplicationapi.enums.BlogStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String blogId;
    private String title;
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private BlogStatus blogStatus;

    @ManyToOne
    private User user;
}
