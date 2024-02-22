package kr.co.black.mockito.controllerTestMain;

import kr.co.black.mockito.controllerTestMain.entity.Article;
import kr.co.black.mockito.controllerTestMain.repository.BlogRepository;
import kr.co.black.mockito.controllerTestMain.service.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {

    @Spy
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    @Test
    @DisplayName("Find All 서비스 테스트")
    void mockBlogServiceFindAllTest(){
        //given
        Article article = Article.builder()
                .title("제목")
                .content("내용")
                .build();

        List<Article> articles= new ArrayList<>();
        articles.add(article);

        given(blogRepository.findAll()).willReturn(articles);

        //when
        List<Article> findArticles = blogService.findAll();

        //then
        assertThat(findArticles.get(0).getTitle()).isEqualTo("제목");
        assertThat(findArticles.get(0).getContent()).isEqualTo("내용");
    }

    @Test
    @DisplayName("Find by Id 서비스 테스트")
    void mockBlogServiceFindByIdTest(){
        //given
        Article article = Article.builder()
                .title("제목")
                .content("내용")
                .build();

        given(blogRepository.findById(1L)).willReturn(Optional.ofNullable(article));


        //when
        Article findArticle = blogService.findById(1L);

        //then
        assertThat(findArticle.getTitle()).isEqualTo("제목");
        assertThat(findArticle.getContent()).isEqualTo("내용");
    }
}
