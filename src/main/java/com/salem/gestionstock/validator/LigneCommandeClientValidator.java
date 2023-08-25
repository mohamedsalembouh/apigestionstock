package com.salem.gestionstock.validator;


import com.salem.gestionstock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {
    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors = new ArrayList<>();
        if(ligneCommandeClientDto == null){
            errors.add("Veuillez entrer quantite ");
            errors.add("Veuillez entrer prix unitaire ");
        }
        if(ligneCommandeClientDto.getQuantite()==null){
            errors.add("entrer quantite");
        }
        return errors;
    }
}
