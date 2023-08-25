package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.ArticleDto;
import com.salem.gestionstock.dto.CategoryDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.repository.CategoryRepository;
import com.salem.gestionstock.services.CategoryService;
import com.salem.gestionstock.validator.ArticleValidator;
import com.salem.gestionstock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {
    CategoryRepository categoryRepository;
   @Autowired
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("Article is not valide");
            throw new InvalidEntityException("category n'est pas valide", ErrorCodes.CATEGORIE_NOT_FOUND,errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }


    @Override
    public CategoryDto findById(Integer id) {
       if(id == null){
           log.error("id is null");
           return null;
       }
        return categoryRepository.findById(id).map(CategoryDto::fromEntity).orElseThrow(
                () -> new InvalidEntityException("Aucun category avec l'id "+id+"n'a ete trouve",ErrorCodes.CATEGORIE_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCodeCat(String code) {
       if(!StringUtils.hasLength(code)){
           log.error("code is null");
           return null;
       }
        return categoryRepository.findByCode(code).map(CategoryDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun category with code = "+code+"ete trouve",ErrorCodes.CATEGORIE_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
       if(id == null){
           log.error("id is null");
       }
     categoryRepository.deleteById(id);
    }
}
