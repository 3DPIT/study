package com.mirero.aegis.demotest.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirero.aegis.demotest.domain.posts.Posts;
import com.mirero.aegis.demotest.service.posts.PostsServiceImpl;
import com.mirero.aegis.demotest.web.dto.PostsResponseDto;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(PostsController.class)
@ExtendWith(MockitoExtension.class)
//@ActiveProfiles("test")
public class PostsControllerTest {

    @Autowired
    protected MockMvc mockMvc;;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    PostsServiceImpl postsService;

    @Test
    public void postsController_savePosts_returnOk() throws Exception{

        //given
        final String url = "/api/v1/posts";
        final String title = "title";
        final String content = "content";
        final String author = "author";
        final PostsSaveReq postsSaveReq = new PostsSaveReq(title, content, author);
        //객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(postsSaveReq);

        when(postsService.save(postsSaveReq)).thenReturn(1L);

        //when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody));

        //then
        result.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void postsController_getPosts_returnOk() throws Exception{
        //given
        final String url = "/api/v1/posts/{id}";
        final String title = "title";
        final String content = "content";
        final String author = "author";
        final Posts posts = new Posts(1L,title, content, author);

        //given
        given(postsService.findById(1L)).willReturn(new PostsResponseDto(posts));

        //when
        ResultActions result = mockMvc.perform(get(url,1));

        //then
        result.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", CoreMatchers.is("content")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", CoreMatchers.is("author")));
    }
}
