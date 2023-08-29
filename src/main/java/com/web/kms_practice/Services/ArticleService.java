package com.web.kms_practice.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.kms_practice.DTOs.ArticleDTO;
import com.web.kms_practice.Repositories.ArticleRepository;
import com.web.kms_practice.Entites.Article;

@Service
@Slf4j
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
        log.info(dto.toString());
        Article created = dto.toEntity();
        log.info(created.toString());
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

   public boolean recommand(Long id, boolean updown){
       Article targetArticle = articleRepository.findById(id).orElse(null);
       if (targetArticle == null){
           return false;
       }

       if (updown){
           targetArticle.setBoomup(targetArticle.getBoomup()+1);
       }else{
           targetArticle.setBoomdown(targetArticle.getBoomdown()+1);
        }
        articleRepository.save(targetArticle);
       return true;
   }

}
