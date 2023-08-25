package com.salem.gestionstock.validator;


import com.salem.gestionstock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {
    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors = new ArrayList<>();
        if(commandeFournisseurDto == null){
            errors.add("Veuillez entrer code ");
            errors.add("Veuillez entrer date ");
            errors.add("Veuillez entrer fournisseur ");
        }
        if(StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("entrer code");
        }
        return errors;
    }
}
