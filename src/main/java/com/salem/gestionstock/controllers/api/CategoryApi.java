package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.CategoryDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.salem.gestionstock.utils.Constants.App_Root;

@Api(App_Root + "/category")
public interface CategoryApi {
        @PostMapping(value = App_Root +"/category/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        CategoryDto save(@RequestBody CategoryDto categoryDto);
        @GetMapping(value = App_Root +"/category/{idCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
        CategoryDto findById(@PathVariable("idCategory") Integer id);
        @GetMapping(value = App_Root +"/category/{codeCategory}",produces = MediaType.APPLICATION_JSON_VALUE)
        CategoryDto findByCodeCategory(@PathVariable("codeCategory") String code);
        @GetMapping(value = App_Root +"/category/all",produces = MediaType.APPLICATION_JSON_VALUE)
        List<CategoryDto> findAll();
        @DeleteMapping(value = App_Root + "/Category/delete/{idCategory}")
        void delete(@PathVariable("idCategory") Integer id);

}
