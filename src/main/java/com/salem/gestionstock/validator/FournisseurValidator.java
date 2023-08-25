package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.ClientDto;
import com.salem.gestionstock.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez renseignez le nom du fournisseur");
            errors.add("Veuillez renseignez l'email du fournisseur");
            errors.add("Veuillez renseignez le numero du telephone");
            return errors;
        }
        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseignez le nom du fournisseur");
        }

        if(!StringUtils.hasLength(dto.getMail())){
            errors.add("Veuillez renseignez l'email du fournisseur");
        }
        if(!StringUtils.hasLength(dto.getNumTel())){
            errors.add("Veuillez renseignez le numero du telephone");
        }
        return errors;
    }
}
