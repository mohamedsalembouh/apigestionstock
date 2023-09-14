package com.salem.gestionstock.controllers;

import com.salem.gestionstock.controllers.api.FournissseurApi;
import com.salem.gestionstock.dto.FournisseurDto;
import com.salem.gestionstock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class FournisseurController implements FournissseurApi {
    FournisseurService fournisseurService;
    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
     fournisseurService.delete(id);
    }
}
