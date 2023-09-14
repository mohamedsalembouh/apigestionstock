package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salem.gestionstock.utils.Constants.Entreprise_Endpoint;

@Api(Entreprise_Endpoint)
public interface EntrepriseApi {
    @PostMapping(Entreprise_Endpoint + "/create")
    EntrepriseDto save(@RequestBody EntrepriseDto entrepriseDto);
    @GetMapping(Entreprise_Endpoint + "/{idEntreprise}")
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
    @GetMapping(Entreprise_Endpoint + "/all")
    List<EntrepriseDto> findAll();
    @DeleteMapping(Entreprise_Endpoint + "/delete/{id}")
    void delete(@PathVariable Integer id);
}
