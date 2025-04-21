package com.example.blogapplicationapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String blogId;
    private String title;
    @Lob
    private String content;
    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDate updatedAt;

    @ManyToOne
    @JsonIgnore
    private User user;
}
