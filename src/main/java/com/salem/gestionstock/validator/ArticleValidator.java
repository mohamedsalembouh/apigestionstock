package com.salem.gestionstock.validator;

import com.salem.gestionstock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();
        if(articleDto == null){
            errors.add("Veuillez renseignez le code article");
            errors.add("Veuillez renseignez designation ");
            errors.add("Veuillez renseignez prix unitaire");
            return errors;
        }
        if (articleDto.getCodeArticle() == null){
            errors.add("Veuillez renseignez code article");
        }
        if(articleDto.getDesignation()==null){
            errors.add("Veuillez renseignez destination");
        }
        if(articleDto.getPrixUnitaireTtc() == null){
            errors.add("Veuillez renseignez prix unitaire ttc");
        }
        return errors;
    }
}
