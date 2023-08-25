package com.salem.gestionstock.validator;



import com.salem.gestionstock.dto.LigneVenteDto;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto ligneVenteDto){
        List<String> errors = new ArrayList<>();
        if(ligneVenteDto == null){
            errors.add("Veuillez entrer quantite ");
            errors.add("Veuillez entrer prix unitaire ");
        }
        if(ligneVenteDto.getQuantite()==null){
            errors.add("entrer quantite");
        }
        return errors;
    }
}
