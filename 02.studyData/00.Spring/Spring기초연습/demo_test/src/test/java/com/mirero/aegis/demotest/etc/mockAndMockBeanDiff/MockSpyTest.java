package com.mirero.aegis.demotest.etc.mockAndMockBeanDiff;

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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockSpyTest {

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
    public void mockAndStubTest(){
        List<String> normalList1= new ArrayList<>();
        normalList1.add("111");
        List<String> normalList2 = new ArrayList<>();
        normalList2.add("222");

//        List<String> mockList = Mockito.mock(normalList1);
        List<String> spyList = Mockito.spy(normalList2);

//        verify(mockList,never()).add("111");
        Assertions.assertThat(spyList.get(0)).isEqualTo("222");
    }
}
