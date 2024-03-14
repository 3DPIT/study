package com.mirero.aegis.demotest.web;

import com.mirero.aegis.demotest.service.posts.PostsServiceImpl;
import com.mirero.aegis.demotest.web.dto.PostsResponseDto;
import com.mirero.aegis.demotest.web.dto.PostsSaveReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostsController {

    private final PostsServiceImpl postsService;

    @PostMapping("/posts")
    public ResponseEntity<Long> save(@RequestBody PostsSaveReq req){
       return ResponseEntity.ok().body(postsService.save(req));
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostsResponseDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(postsService.findById(id));
    }
}
