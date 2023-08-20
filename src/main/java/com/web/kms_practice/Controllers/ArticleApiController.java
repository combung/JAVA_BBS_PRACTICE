package com.web.kms_practice.Controllers;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.kms_practice.DTOs.ArticleDTO;
import com.web.kms_practice.Entites.Article;
import com.web.kms_practice.Services.ArticleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ArticleApiController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/article/{id}")
    public ResponseEntity<Article> show(@PathVariable Long id){
        Article article = articleService.show(id);
        if(article == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return  ResponseEntity.status(HttpStatus.OK).body(article);
    } 

    @PostMapping("/article/create")
    public ResponseEntity<Article> create(@RequestBody ArticleDTO dto){
        
        log.info(dto.toString());
        Article created = articleService.create(dto);
        if (created != null){
            return ResponseEntity.ok().body(created);
        }else{
            return ResponseEntity.ok().build();
        }
    }

    @PatchMapping("/article/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleDTO dto){
        Article updated = articleService.update(id, dto);
        if (updated != null){
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/article/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        boolean deleteStatus = articleService.delete(id);
        if (deleteStatus){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
