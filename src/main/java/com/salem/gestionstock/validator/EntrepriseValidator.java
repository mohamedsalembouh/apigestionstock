package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();
        if(entrepriseDto == null){
            errors.add("Veuillez renseignez le nom de l'entreprise");
            errors.add("Veuillez renseignez l'email de l'entreprise");
            errors.add("Veuillez renseignez le numero de telephone de l'entreprise");
            return errors;
        }
        if(!StringUtils.hasLength(entrepriseDto.getName())){
            errors.add("Veuillez renseignez le nom de l'entreprise");
        }
        if(!StringUtils.hasLength(entrepriseDto.getEmail())){
            errors.add("Veuillez renseignez l'email de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Veuillez renseignez le numero de telephone de l'entreprise");
        }
        return errors;
    }
}
