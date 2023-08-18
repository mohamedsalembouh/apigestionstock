package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Adresse;
import com.salem.gestionstock.model.Category;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdresseDto {
    private int id;
    private String addresse1;
    private String addresse2;
    private String ville;
    private String codePostale;
    private String pays;

    public AdresseDto fromEntity(Adresse adresse){
        if(adresse==null){
            return null;
        }
        return AdresseDto.builder()
                .addresse1(adresse.getAddresse1())
                .addresse2(adresse.getAddresse2())
                .ville(adresse.getVille())
                .codePostale(adresse.getVille())
                .pays(adresse.getPays())
                .build();

    }
    public Adresse toEntity(AdresseDto adresseDto){
        if(adresseDto==null){
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAddresse1(adresseDto.addresse1);
        adresse.setAddresse2(adresseDto.addresse2);
        adresse.setVille(adresseDto.ville);
        adresse.setCodePostale(adresseDto.codePostale);
        adresse.setPays(adresseDto.pays);
        return adresse;
    }
}
