package com.example.exernews_article.Service;

import com.example.exernews_article.Model.NewsArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle> newsArticles = new ArrayList<>();

    public ArrayList<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public void addNewsArticle(NewsArticle newsArticle) {
        newsArticles.add(newsArticle);
    }

    public boolean updateNewsArticle(String id ,NewsArticle newsArticle) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equals(id)) {
                newsArticles.set(i,newsArticle);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNewsArticle(String id) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equals(id)) {
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean publishNewsArticle(String id) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equals(id)) {
                if(newsArticles.get(i).isPublished()==false){
                    newsArticles.get(i).setPublished(true);
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<NewsArticle> getNewsArticlesPublished() {
        ArrayList<NewsArticle> newsArticlesPublished = new ArrayList<>();
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).isPublished()==true) {
                newsArticlesPublished.add(newsArticles.get(i));
            }
        }
        if (newsArticlesPublished == null) {
            return null;
        }else {
            return newsArticlesPublished;
        }
    }

    public ArrayList<NewsArticle> getNewsArticlesByCategory(String category) {
        ArrayList<NewsArticle> newsArticlesByCategory = new ArrayList<>();
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getCategory().equals(category)) {
                newsArticlesByCategory.add(newsArticles.get(i));
            }
        }
        if (newsArticlesByCategory == null) {
            return null;
        }
        return newsArticlesByCategory;
    }

}
