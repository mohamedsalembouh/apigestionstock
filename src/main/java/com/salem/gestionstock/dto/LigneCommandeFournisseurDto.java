package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.CommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeFournisseurDto {
    private int id;
    private Article article;

    private CommandeFournisseurDto commandeFournisseur;
    private BigDecimal quantite;
    private BigDecimal prixunitaire;
}
