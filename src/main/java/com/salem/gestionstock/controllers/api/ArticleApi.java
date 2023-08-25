package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.salem.gestionstock.utils.Constants.Url_Root;

public interface ArticleApi {

    @RequestMapping(value = Url_Root +"/article/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value = Url_Root +"/article/idArticle",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = Url_Root + "/article/codeArticle",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String code);

    @GetMapping(value = Url_Root + "/article/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = Url_Root + "/article/delete/idArticle")
    void delete(@PathVariable("idArticle") Integer id);
}
