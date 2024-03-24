package com.mirero.aegis.demotest.domain.posts;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String author;
}
