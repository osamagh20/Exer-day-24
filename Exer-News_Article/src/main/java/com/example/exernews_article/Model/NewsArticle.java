package com.example.exernews_article.Model;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotEmpty(message = "Enter your ID")
    private String id;
    @NotEmpty(message = "Enter your title")
    @Size(max = 100)
    private String title;
    @NotEmpty(message = "Enter the author")
    @Size(min=4,max = 20)
    private String author;
    @NotEmpty(message = "Enter the content")
    @Size(min=5)
    private String content;
    @NotEmpty(message = "Enter the category")
    @Pattern(regexp = "^(politics|sports|technology)$",message ="Enter valid category : politics or sports or technology")
    private String category;
    @NotEmpty(message = "Enter url of image")
    private String imageUrl;
    @AssertFalse
    private boolean isPublished;
    private Date publishDate;
}
