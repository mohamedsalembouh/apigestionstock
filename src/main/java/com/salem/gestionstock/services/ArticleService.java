package com.salem.gestionstock.services;

import com.salem.gestionstock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String code);

   List<ArticleDto> findAll();

   void delete(Integer id);
}
