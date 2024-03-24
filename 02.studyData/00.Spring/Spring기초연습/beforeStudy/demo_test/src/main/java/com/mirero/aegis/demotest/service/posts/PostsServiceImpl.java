package com.mirero.aegis.demotest.service.posts;

import com.mirero.aegis.demotest.domain.posts.Posts;
import com.mirero.aegis.demotest.domain.posts.PostsRepo;
import com.mirero.aegis.demotest.web.dto.PostsResponseDto;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsServiceImpl implements PostsService{

    private final PostsRepo postsRepo;

    @Transactional
    @Override
    public long save(PostsSaveReq req) {
         return postsRepo.save(req.toEntity()).getId();
    }

    @Override
    public PostsResponseDto findById(Long id) {
        Posts posts =  postsRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("id 없음"));

        return new PostsResponseDto(posts);
    }
}
