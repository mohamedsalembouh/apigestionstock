package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.salem.gestionstock.utils.Constants.App_Root;

@Api(App_Root + "/articles")
public interface ArticleApi {

    @PostMapping(value = App_Root +"/article/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un article",notes = "cette method permet d'enregistrer ou modifier un article",response = ArticleApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'article est cree ou modifiee"),
            @ApiResponse(code = 400,message = "L'article n'est pas valide")
    })
    ArticleDto save(@RequestBody ArticleDto articleDto);

    @GetMapping(value = App_Root +"/article/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un article",notes = "cette method permet de chercher un article par son id",response = ArticleApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'article est trouvee"),
            @ApiResponse(code = 404,message = "Aucun article n'a ete trouve avec ce id ")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = App_Root + "/article/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher un article par code",notes = "cette method permet de chercher un article par son code",response = ArticleApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'article est trouvee"),
            @ApiResponse(code = 404,message = "Aucun article n'a ete trouve avec ce code ")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String code);

    @GetMapping(value = App_Root + "/article/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvoyer la liste des articles",notes = "cette method permet de trouver la liste des articles",responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "la liste des articles"),
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value = App_Root + "/article/delete/{idArticle}")
    @ApiOperation(value = "supprimer un article",notes = "cette method permet de supprimer un article",response = ArticleApi.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "L'article est supprime"),
    })
    void delete(@PathVariable("idArticle") Integer id);
}
