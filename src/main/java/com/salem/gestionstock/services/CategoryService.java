package com.salem.gestionstock.services;

import com.salem.gestionstock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCodeCat(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
