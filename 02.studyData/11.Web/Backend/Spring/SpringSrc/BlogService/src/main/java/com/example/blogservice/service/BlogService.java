package com.example.blogservice.service;

import com.example.blogservice.domain.Article;
import com.example.blogservice.dto.AddArticleRequest;
import com.example.blogservice.dto.UpdateArticleRequest;
import com.example.blogservice.repository.BlogRepository;
import jakarta.transaction.Transactional;
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

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
