package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Adresse;
import com.salem.gestionstock.model.Entreprise;
import com.salem.gestionstock.model.Roles;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class UtilisateurDto {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String motDePasse;
    private Adresse adresse;
    private String photo;

    private EntrepriseDto enterprise;
    private List<RolesDto> roles;
}
