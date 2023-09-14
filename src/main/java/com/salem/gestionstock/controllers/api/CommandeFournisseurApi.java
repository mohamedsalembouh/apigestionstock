package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salem.gestionstock.utils.Constants.App_Root;
import static com.salem.gestionstock.utils.Constants.CommandeFournisseur_Endpoint;

@Api(CommandeFournisseur_Endpoint)
public interface CommandeFournisseurApi {
    @PostMapping(CommandeFournisseur_Endpoint + "/create")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto commandeFournisseurDto);
    @GetMapping(CommandeFournisseur_Endpoint + "/{idCommande}")
    CommandeFournisseurDto findById(@PathVariable("idCommande") Integer id);
    @GetMapping(CommandeFournisseur_Endpoint + "/{code}")
    CommandeFournisseurDto findByCode(@PathVariable String code);
    @GetMapping(CommandeFournisseur_Endpoint + "/all")
    List<CommandeFournisseurDto> findAll();
    @DeleteMapping(CommandeFournisseur_Endpoint + "/delete/{id}")
    void delete(@PathVariable Integer id);
}
