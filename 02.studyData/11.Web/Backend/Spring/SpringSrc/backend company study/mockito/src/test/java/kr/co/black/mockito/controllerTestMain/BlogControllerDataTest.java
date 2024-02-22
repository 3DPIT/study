package kr.co.black.mockito.controllerTestMain;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.black.mockito.controllerTestMain.controller.BlogController;
import kr.co.black.mockito.controllerTestMain.dto.AddArticleRequest;
import kr.co.black.mockito.controllerTestMain.entity.Article;
import kr.co.black.mockito.controllerTestMain.repository.BlogRepository;
import kr.co.black.mockito.controllerTestMain.service.BlogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogControllerDataTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper ojbectMapper; //직렬화, 역직렬화를 위한 클래스

    @Autowired
    BlogService blogService;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    BlogController blogController;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(blogController).build();
        blogRepository.deleteAll();
    }

    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    public void addArticle() throws Exception{

        //given
        final String url = "/api/articles";
        final String title = " title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        //객체 JSON으로 직렬화
        final String requestBody = ojbectMapper.writeValueAsString(userRequest);

        //when
        //설정한 내용을 바탕으로 요청 전송
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody));

        //then
        result.andExpect(status().isCreated());

        List<Article> articles = blogRepository.findAll();

        assertThat(articles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);
    }
}