package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez renseignez le nom du client");
            errors.add("Veuillez renseignez l'email du client");
            errors.add("Veuillez renseignez le numero du telephone");
            return errors;
        }
        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseignez le nom du client");
        }

        if(!StringUtils.hasLength(dto.getMail())){
            errors.add("Veuillez renseignez l'email du client");
        }
        if(!StringUtils.hasLength(dto.getNumTel())){
            errors.add("Veuillez renseignez le numero du telephone");
        }
        return errors;
    }
}
