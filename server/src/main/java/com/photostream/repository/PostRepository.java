package com.photostream.repository;

import com.photostream.entity.Post;
import com.photostream.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserOrderByCreatedAtDesc(User user);

    List<Post> findAllByOrderByCreatedAtDesc();

    Optional<Post> findByIdAndUser(Long id, User user);
}
