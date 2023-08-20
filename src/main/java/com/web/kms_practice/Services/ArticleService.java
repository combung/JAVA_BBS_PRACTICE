package com.web.kms_practice.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.kms_practice.DTOs.ArticleDTO;
import com.web.kms_practice.Repositories.ArticleRepository;
import com.web.kms_practice.Entites.Article;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article show(Long id){
        Article targetArticle = articleRepository.findById(id).orElse(null);
        return targetArticle;
    }

    public Article create(ArticleDTO dto){
        if (dto.getId() != null){
            return null;
        }
        Article created = dto.toEntity();
        articleRepository.save(created);
        return created;
    }

    public Article update(Long id, ArticleDTO dto){
        Article updateTarget = articleRepository.findById(id).orElse(null);
        if(updateTarget == null){
            return updateTarget;
        }
        updateTarget.patch(dto);
        articleRepository.save(updateTarget);
        return updateTarget;

    }

    public boolean delete(Long id){
        Article deleteTarget = articleRepository.findById(id).orElse(null);
        if (deleteTarget != null){
            articleRepository.delete(deleteTarget);
            return true;
        }else{
            return false;
        }
    }

}
