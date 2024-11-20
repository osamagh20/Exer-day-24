package com.example.exernews_article.Controller;

import com.example.exernews_article.Model.NewsArticle;
import com.example.exernews_article.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/news-article")
@RequiredArgsConstructor
public class newsArticleController {
    private final NewsArticleService newsArticleService;

    @GetMapping("/get")
    public ResponseEntity getNewsArticle(){
        ArrayList<NewsArticle> newsArticles = newsArticleService.getNewsArticles();
        return ResponseEntity.status(200).body(newsArticles);
    }

    @PostMapping("/add")
    public ResponseEntity addNewsArticle(@RequestBody @Valid NewsArticle newsArticle, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        newsArticleService.addNewsArticle(newsArticle);
        return ResponseEntity.status(200).body("news article added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticle(@PathVariable String id, @RequestBody @Valid NewsArticle newsArticle, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = newsArticleService.updateNewsArticle(id, newsArticle);
        if(isUpdated){
            return ResponseEntity.status(200).body("updated news article");
        }
            return ResponseEntity.status(400).body("id not found");


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticle(@PathVariable String id){
        boolean isDeleted = newsArticleService.deleteNewsArticle(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("deleted news article");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity publishNewsArticle(@PathVariable String id){
        boolean isPublished = newsArticleService.publishNewsArticle(id);
        if(isPublished){
            return ResponseEntity.status(200).body("published news article");
        }
        return ResponseEntity.status(400).body("id not found");
    }

    @GetMapping("/get-published")
    public ResponseEntity getNewsIsPublished(){
        ArrayList<NewsArticle> newsArticlesPublished = newsArticleService.getNewsArticlesPublished();
        return ResponseEntity.status(200).body(newsArticlesPublished);
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getNewsArticleCategory(@PathVariable String category){
        ArrayList<NewsArticle> newsArticlesCategory = newsArticleService.getNewsArticlesByCategory(category);
        if(newsArticlesCategory == null){
            return ResponseEntity.status(400).body("category not found");
        }
        return ResponseEntity.status(200).body(newsArticlesCategory);
    }


}
