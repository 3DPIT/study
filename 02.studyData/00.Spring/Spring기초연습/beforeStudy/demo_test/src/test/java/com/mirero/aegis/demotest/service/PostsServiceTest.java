package com.mirero.aegis.demotest.service;

import com.mirero.aegis.demotest.domain.posts.Posts;
import com.mirero.aegis.demotest.domain.posts.PostsRepo;
import com.mirero.aegis.demotest.service.posts.PostsServiceImpl;
import com.mirero.aegis.demotest.web.dto.PostsResponseDto;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostsServiceTest {

    @Mock
    private PostsRepo postsRepo;

    @InjectMocks
    private PostsServiceImpl postsService;

    @Test
    public void PostsServiceTest_savePosts_returnOk() {

        //given
        Posts posts =Posts.builder()
               .id(1L)
                .title("title")
                .content("content")
                .author("author")
                .build();

        PostsSaveReq req =PostsSaveReq.builder()
                .title("title")
                .content("content")
                .author("author")
                .build();

       when(postsRepo.save(any(Posts.class))).thenReturn(posts);

       //when
        long id =  postsService.save(req);

        //then
        verify(postsRepo, times(1)).save(any(Posts.class));
       Assertions.assertThat(id).isEqualTo(1);
    }

    @Test
    public void PostsServiceTest_findById_returnOk() {
        //given
        Posts posts =Posts.builder()
                .id(1L)
                .title("title")
                .content("content")
                .author("author")
                .build();

        when(postsRepo.findById(1L)).thenReturn(Optional.of(posts));

        //when
        PostsResponseDto postsResponseDto =  postsService.findById(1L);

        //then
        Assertions.assertThat(postsResponseDto.getId()).isEqualTo(1);
        Assertions.assertThat(postsResponseDto.getTitle()).isEqualTo("title");
        Assertions.assertThat(postsResponseDto.getContent()).isEqualTo("content");
        Assertions.assertThat(postsResponseDto.getAuthor()).isEqualTo("author");
    }
}

