package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.AdresseDto;
import com.salem.gestionstock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if(utilisateurDto == null){
            errors.add("veuillez renseigner nom utilisateur");
            errors.add("veuillez renseigner email utilisateur");
            errors.add("veuillez renseigner adresse utilisateur");
            return errors;
        }
            if( !StringUtils.hasLength(utilisateurDto.getNom())){
                errors.add("veuillez renseigner nom utilisateur");
            }
            if( !StringUtils.hasLength(utilisateurDto.getEmail())){
                errors.add("veuillez renseigner email utilisateur");
            }
            if( !StringUtils.hasLength(utilisateurDto.getMotDePasse())){
                errors.add("veuillez renseigner mot de passe utilisateur");
            }
            if(AdresseDto.toEntity(utilisateurDto.getAdresse())==null){
                errors.add("veuillez renseigner addresse utilisateur");
            }else{
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAddresse1())){
                    errors.add("adresse1 est obligatoire");
                }
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                    errors.add("pays est obligatoire");
                }
                if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                    errors.add("code postale est obligatoire");
                }
            }

        return errors;
    }
}
