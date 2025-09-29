package com.example.blog.service.impl;

import com.example.blog.domain.Article;
import com.example.blog.repository.ArticleRepository;
import com.example.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        return articleRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(article.getTitle());
                    existing.setContent(article.getContent());
                    existing.setAuthor(article.getAuthor());
                    return articleRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

}
