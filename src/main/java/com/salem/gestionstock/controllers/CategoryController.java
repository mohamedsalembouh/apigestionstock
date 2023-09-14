package com.salem.gestionstock.controllers;

import com.salem.gestionstock.controllers.api.CategoryApi;
import com.salem.gestionstock.dto.CategoryDto;
import com.salem.gestionstock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController implements CategoryApi {
    CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
        return categoryService.findByCodeCat(code);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
     categoryService.delete(id);
    }
}
