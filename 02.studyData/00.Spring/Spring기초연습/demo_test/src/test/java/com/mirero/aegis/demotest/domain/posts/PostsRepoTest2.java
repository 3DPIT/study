package com.mirero.aegis.demotest.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2)
public class PostsRepoTest2 {

    @Autowired
    private PostsRepo postsRepo;

    @Test
    public void PostsRepoTest_savePosts_returnOk() {
        Posts posts1 = Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();

        Posts posts2 = Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();

        postsRepo.save(posts1);
        postsRepo.save(posts2);

        List<Posts> postsList= postsRepo.findAll();
        Assertions.assertThat(postsList.size()).isEqualTo(2);
    }
}
