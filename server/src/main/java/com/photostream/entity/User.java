package com.photostream.entity;

import com.photostream.entity.enums.ERole;
import jakarta.persistence.PrePersist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Set;

public class User {
    private Long id;
    private String name;
    private String userName;
    private String lastName;
    private String email;
    private String bio;
    private String password;

    private Set<ERole> role = new HashSet<>();
    private List<Post> posts = new ArrayList<>();
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
