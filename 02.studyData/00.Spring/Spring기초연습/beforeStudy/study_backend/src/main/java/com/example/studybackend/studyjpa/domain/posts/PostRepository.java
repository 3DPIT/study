package com.example.studybackend.studyjpa.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
