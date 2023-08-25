package com.salem.gestionstock.validator;


import com.salem.gestionstock.dto.VentesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentesValidator {

    public static List<String> validate(VentesDto ventesDto){
        List<String> errors = new ArrayList<>();
        if(ventesDto == null){
            errors.add("Veuillez entrer code ");
            errors.add("Veuillez entrer date ");
        }
        if(StringUtils.hasLength(ventesDto.getCode())){
            errors.add("entrer code");
        }
        return errors;
    }
}
