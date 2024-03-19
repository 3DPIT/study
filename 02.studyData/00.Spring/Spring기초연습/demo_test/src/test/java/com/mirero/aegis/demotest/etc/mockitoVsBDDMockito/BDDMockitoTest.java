package com.mirero.aegis.demotest.etc.mockitoVsBDDMockito;

import com.mirero.aegis.demotest.domain.posts.Posts;
import com.mirero.aegis.demotest.domain.posts.PostsRepo;
import com.mirero.aegis.demotest.service.posts.PostsServiceImpl;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class BDDMockitoTest {

    @Mock
    private PostsRepo postsRepo;

    @InjectMocks
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

        given(postsRepo.save(Mockito.any(Posts.class))).willReturn(posts);

        //when
        long id = postsService.save(req);

        //then
        then(postsRepo).should(times(1)).save(Mockito.any(Posts.class));
        then(postsRepo).should(times(1)).findById(1L)
        Assertions.assertThat(id).isEqualTo(1);
    }
}
