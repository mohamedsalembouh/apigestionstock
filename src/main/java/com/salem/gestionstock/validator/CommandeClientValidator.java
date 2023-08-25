package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();
        if(commandeClientDto == null){
            errors.add("Veuillez entrer code ");
            errors.add("Veuillez entrer date ");
            errors.add("Veuillez entrer client ");
        }
        if(StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("entrer code");
        }
        return errors;
    }
}
