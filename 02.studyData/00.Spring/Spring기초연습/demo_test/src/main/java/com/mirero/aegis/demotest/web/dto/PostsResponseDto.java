package com.mirero.aegis.demotest.web.dto;

import com.mirero.aegis.demotest.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title =entity.getTitle();
        this.content =entity.getContent();
        this.author= entity.getAuthor();
    }
}
