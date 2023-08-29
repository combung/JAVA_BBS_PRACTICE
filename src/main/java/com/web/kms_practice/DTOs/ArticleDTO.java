package com.web.kms_practice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import com.web.kms_practice.Entites.Article;

@AllArgsConstructor
@Getter
@ToString
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;
    private Long boomup;
    private Long boomdown;
    private String auth;

    public Article toEntity(){
        Article article = new Article();
        article.setTitle(this.title);
        article.setContent(this.content);
        if (this.auth != null){
            article.setAuth(this.auth);
        }
        return article;
    }
}
