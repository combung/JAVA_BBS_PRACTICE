package com.web.kms_practice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web.kms_practice.Entites.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
