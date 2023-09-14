package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.CategoryDto;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.services.CategoryService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImpTest {
    @Autowired
    private CategoryService service;
    @Test
    public void shouldSaveCategoryWithSuccess(){
        CategoryDto expectedCategory = CategoryDto.builder()
                .code("code test")
                .designation("designation test")
                .identreprise(1)
                .build();

        CategoryDto savedCategory = service.save(expectedCategory);

       assertNotNull(savedCategory);
        assertNotNull(savedCategory.getId());
        assertEquals(expectedCategory.getCode(),savedCategory.getCode());
        assertEquals(expectedCategory.getDesignation(),savedCategory.getDesignation());
        assertEquals(expectedCategory.getIdentreprise(),savedCategory.getIdentreprise());
    }
    @Test
    public void shouldThrowInvalidEntityException(){
        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, () -> service.findById(0) );
        assertEquals(ErrorCodes.CATEGORIE_NOT_FOUND,expectedException.getErrorCodes());
        assertEquals(1,expectedException.getErrors().size());
        assertEquals("Veuillez renseignez le code ",expectedException.getErrors().get(0));
    }
}