package com.web.kms_practice.Controllers;

import com.web.kms_practice.Repositories.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.web.kms_practice.Entites.Article;
import java.util.List;


@Controller
@Slf4j
public class PageController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Article> articles = articleRepository.findAll();
        log.info("here");
        log.info(articles.toString());
        model.addAttribute("filename", "index");
        model.addAttribute("articles", articles);
        return "/index";
    }

    @GetMapping("/articleview/{id}")
    public String showArticle(@PathVariable Long id, Model model){
        Article targetArticle = articleRepository.findById(id).orElse(null);
        if(targetArticle==null){
            model.addAttribute("filename", "error_page");
            return "/error_page";
        }else{
            model.addAttribute("filename", "article_view");
            model.addAttribute("article", targetArticle);
            return "/article_view";
        }
    }
}
