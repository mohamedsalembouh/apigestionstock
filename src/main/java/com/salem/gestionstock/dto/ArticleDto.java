package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {
    private int id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxtva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto category;

    private Integer identreprise;
    public static ArticleDto fromEntity(Article article){
        if(article == null){
            return null;
        }
        return  ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .tauxtva(article.getTauxtva())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .identreprise(article.getIdentreprise())
                .build();
    }
    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setTauxtva(articleDto.getTauxtva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        article.setIdentreprise(articleDto.getIdentreprise());
        return article;
    }
}
