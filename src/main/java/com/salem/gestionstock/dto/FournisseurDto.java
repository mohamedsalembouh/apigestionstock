package com.salem.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salem.gestionstock.model.Adresse;
import com.salem.gestionstock.model.CommandeFournisseur;
import com.salem.gestionstock.model.Fournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {
    private int id;
    private String nom;
    private String prenom;
    private Adresse adress;
    private String photo;
    private String mail;
    private String numTel;

    private Integer identreprise;

    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseur;

    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if(fournisseur == null){
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adress(fournisseur.getAdress())
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .identreprise(fournisseur.getIdentreprise())
                .build();
    }
    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto == null){
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdress(fournisseurDto.getAdress());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setMail(fournisseurDto.getMail());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setIdentreprise(fournisseurDto.getIdentreprise());
        return fournisseur;
    }
}
