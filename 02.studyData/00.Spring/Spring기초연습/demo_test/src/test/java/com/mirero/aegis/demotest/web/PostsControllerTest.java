package com.mirero.aegis.demotest.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirero.aegis.demotest.domain.posts.Posts;
import com.mirero.aegis.demotest.service.posts.PostsService;
import com.mirero.aegis.demotest.service.posts.PostsServiceImpl;
import com.mirero.aegis.demotest.web.dto.PostsResponseDto;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(PostsController.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PostsControllerTest {

    @Autowired
    protected MockMvc mockMvc;;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    PostsServiceImpl postsService;

    @Test
    public void postsController_savePosts_returnOk() throws Exception{
        given(postsService.save(new PostsSaveReq("title", "content", "author"))).willReturn(1L);

        ResultActions result = mockMvc.perform(post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new PostsSaveReq("title", "content", "author"))));

        result.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", CoreMatchers.is(0)));
    }

    @Test
    public void postsController_getPosts_returnOk() throws Exception{
        given(postsService.findById(1L)).willReturn(new PostsResponseDto(new Posts(1L, "title", "content", "author")));

        ResultActions result = mockMvc.perform(get("/api/v1/posts/{id}",1));

        result.andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is("title")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", CoreMatchers.is("content")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author", CoreMatchers.is("author")));
    }
}
