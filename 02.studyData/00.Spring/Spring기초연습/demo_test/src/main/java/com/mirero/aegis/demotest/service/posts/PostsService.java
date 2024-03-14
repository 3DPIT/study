package com.mirero.aegis.demotest.service.posts;

import com.mirero.aegis.demotest.web.dto.PostsResponseDto;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;

public interface PostsService {
    public Long save(PostsSaveReq req);
    public PostsResponseDto findById(Long id);
}
