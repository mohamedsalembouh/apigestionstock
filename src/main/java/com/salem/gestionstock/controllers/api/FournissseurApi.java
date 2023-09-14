package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salem.gestionstock.utils.Constants.FOURNISSEUR_ENDPOINTS;

@Api(FOURNISSEUR_ENDPOINTS)
public interface FournissseurApi {
    @PostMapping(FOURNISSEUR_ENDPOINTS + "/create")
    FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
    @GetMapping(FOURNISSEUR_ENDPOINTS + "/{id}")
    FournisseurDto findById(@PathVariable Integer id);
    @GetMapping(FOURNISSEUR_ENDPOINTS + "/all")
    List<FournisseurDto> findAll();
   @DeleteMapping(FOURNISSEUR_ENDPOINTS + "/delete/{id}")
    void delete(@PathVariable Integer id);
}
