package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Adresse;
import com.salem.gestionstock.model.Entreprise;
import com.salem.gestionstock.model.Roles;
import com.salem.gestionstock.model.Utilisateur;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class UtilisateurDto {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String motDePasse;
    private AdresseDto adresse;
    private String photo;

    private EntrepriseDto enterprise;
    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }
       return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .motDePasse(utilisateur.getMotDePasse())
                .photo(utilisateur.getPhoto())
               .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
               .enterprise(EntrepriseDto.fromEntity(utilisateur.getEnterprise()))
               .roles(
                       utilisateur.getRoles()!=null?
                               utilisateur.getRoles().stream().map(RolesDto::fromEntity).collect(Collectors.toList())
                               :null
               )
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setPhoto(utilisateur.getPhoto());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEnterprise(EntrepriseDto.toEntity(utilisateurDto.getEnterprise()));
        return utilisateur;
    }
}
