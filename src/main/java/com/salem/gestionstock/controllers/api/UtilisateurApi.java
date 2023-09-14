package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salem.gestionstock.utils.Constants.Utilisateur_Endpoint;

@Api(Utilisateur_Endpoint)
public interface UtilisateurApi {
    @PostMapping(Utilisateur_Endpoint + "/create")
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);
    @GetMapping(Utilisateur_Endpoint + "/{id}")
    UtilisateurDto findById(@PathVariable Integer id);
    @GetMapping(Utilisateur_Endpoint + "/all")
    List<UtilisateurDto> findAll();
    @DeleteMapping(Utilisateur_Endpoint + "/delete/{id}")
    void delete(@PathVariable Integer id);
}
