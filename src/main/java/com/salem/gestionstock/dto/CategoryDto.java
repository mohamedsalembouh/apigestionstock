package com.salem.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Data
public class CategoryDto {
    private int id;
    private String code;
    private String designation;
    @JsonIgnore
    private List<ArticleDto> articles;

    public CategoryDto fromEntity(Category category){
        if(category==null){
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();

    }
    public Category toEntity(CategoryDto categoryDto){
        if(categoryDto==null){
            return null;
        }
        Category category = new Category();
        category.setCode(categoryDto.code);
        category.setDesignation(categoryDto.designation);
        return category;
    }
}
