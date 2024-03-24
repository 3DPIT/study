package com.mirero.aegis.demotest.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo extends JpaRepository<Posts, Long> {
}
