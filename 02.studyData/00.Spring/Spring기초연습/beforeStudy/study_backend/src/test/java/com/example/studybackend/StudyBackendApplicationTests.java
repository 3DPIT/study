package com.example.studybackend;

import com.example.studybackend.studyjpa.domain.posts.PostRepository;
import com.example.studybackend.studyjpa.domain.posts.Posts;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudyBackendApplicationTests {

    @Autowired
    PostRepository postRepository;

    @After
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        //given
        String title = "테스트 게시글 제목";
        String content = "테스트 본문";

        postRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("3dpit@black.com")
                .build());

        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
