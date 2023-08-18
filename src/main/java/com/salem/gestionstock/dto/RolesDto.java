package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {
    private int id;
    private String roleName;

    private UtilisateurDto utilisateur;
}
