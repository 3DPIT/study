package com.mirero.aegis.demotest.etc.mockAndMockBeanDiff;

import com.mirero.aegis.demotest.domain.posts.Posts;
import com.mirero.aegis.demotest.domain.posts.PostsRepo;
import com.mirero.aegis.demotest.service.posts.PostsServiceImpl;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MockBeanSpyBeanTest {

    @MockBean
    private PostsRepo postsRepo;

    @Autowired
    private PostsServiceImpl postsService;

    @Test
    public void PostsServiceTest_savePosts_returnOk() {

        //given
        Posts posts = Posts.builder()
                .id(1L)
                .title("title")
                .content("content")
                .author("author")
                .build();

        PostsSaveReq req = PostsSaveReq.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();

        when(postsRepo.save(any(Posts.class))).thenReturn(posts);

        //when
        long id = postsService.save(req);

        //then
        verify(postsRepo, times(1)).save(any(Posts.class));
        Assertions.assertThat(id).isEqualTo(1);
    }
}

