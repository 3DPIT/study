package com.mirero.aegis.demotest.web.dto;

import com.mirero.aegis.demotest.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PostsSaveReq {

    private String title;
    private String content;
    private String author;


    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
