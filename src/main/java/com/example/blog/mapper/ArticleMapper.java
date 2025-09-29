package com.example.blog.mapper;

import com.example.blog.domain.Article;
import com.example.blog.dto.ArticleDTO;

public class ArticleMapper {
    public static ArticleDTO toDto(Article article) {
        if (article == null) return null;

        return new ArticleDTO(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getAuthor() != null ? article.getAuthor().getName() : null
        );
    }

    public static Article toEntity(ArticleDTO dto) {
        if (dto == null) return null;

        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        // Author sa nastaví v service podľa ID autora
        return article;
    }
}
