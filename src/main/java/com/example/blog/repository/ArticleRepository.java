package com.example.blog.repository;

import com.example.blog.domain.Article;
import com.example.blog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByAuthor(Author author);
    List<Article> findByTitleContaining(String keyword);
}
