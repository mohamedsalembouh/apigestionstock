package com.salem.gestionstock.repository;

import com.salem.gestionstock.dto.ArticleDto;
import com.salem.gestionstock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findByCodeArticle(String code);
}
