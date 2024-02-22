package kr.co.black.mockito.controllerTestMain;

import kr.co.black.mockito.controllerTestMain.entity.Article;
import kr.co.black.mockito.controllerTestMain.repository.BlogRepository;
import kr.co.black.mockito.controllerTestMain.service.BlogService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BlogRepositoryTest {

    @Spy
    private BlogRepository blogRepository;

    @Test
    @DisplayName("레파지토리 테스트")
    void mockBlogRepositoryTest(){
        //given
        Article article = Article.builder()
                .title("제목")
                .content("내용")
                .build();

        List<Article> articles= new ArrayList<>();
        articles.add(article);

        given(blogRepository.findAll()).willReturn(articles);

        //when
        List<Article> findArticles=  blogRepository.findAll();

        //then
        assertThat(findArticles.size()).isEqualTo(1);
        assertThat(articles.get(0).getTitle()).isEqualTo(findArticles.get(0).getTitle());
        assertThat(articles.get(0).getContent()).isEqualTo(findArticles.get(0).getContent());
    }
}
