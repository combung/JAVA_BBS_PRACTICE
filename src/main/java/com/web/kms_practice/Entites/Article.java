package com.web.kms_practice.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.web.kms_practice.DTOs.ArticleDTO;
import org.hibernate.Internal;
import org.hibernate.annotations.ColumnDefault;

// @AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long boomup = 0L;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long boomdown = 0L;

    @Column
    private String auth = "dbehd";

    public void patch(ArticleDTO dto){
        if (dto.getTitle() != null){
            this.title = dto.getTitle();
        }

        if (dto.getContent() != null){
            this.content = dto.getContent();
        }
    }
}
