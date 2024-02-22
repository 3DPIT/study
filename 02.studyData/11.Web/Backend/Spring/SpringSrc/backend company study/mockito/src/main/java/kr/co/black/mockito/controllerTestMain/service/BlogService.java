package kr.co.black.mockito.controllerTestMain.service;

import kr.co.black.mockito.controllerTestMain.dto.AddArticleRequest;
import kr.co.black.mockito.controllerTestMain.entity.Article;
import kr.co.black.mockito.controllerTestMain.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final 붙거나 @Nonnull이 붙은 필드의 생성자 추가
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request){

        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(Long id){
        return blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: " + id));
    }
}
