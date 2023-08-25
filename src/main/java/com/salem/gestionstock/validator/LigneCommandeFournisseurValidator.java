package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.CommandeFournisseurDto;
import com.salem.gestionstock.dto.LigneCommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        List<String> errors = new ArrayList<>();
        if(ligneCommandeFournisseurDto == null){
            errors.add("Veuillez entrer quantite ");
            errors.add("Veuillez entrer prix unitaire ");
        }
        if(ligneCommandeFournisseurDto.getQuantite() == null){
            errors.add("entrer quantite");
        }
        return errors;
    }
}
