package com.mirero.aegis.demotest.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostsRepoTest {

    @Spy
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

        when(postsRepo.save(Mockito.any(Posts.class))).thenReturn(posts1, posts2);


        List<Posts> postsList= postsRepo.findAll();
        Assertions.assertThat(postsList.size()).isEqualTo(2);
    }
}
