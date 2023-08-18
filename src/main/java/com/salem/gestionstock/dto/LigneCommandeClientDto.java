package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneCommandeClientDto {
    private int id;
    private Article article;

    private CommandeClientDto comandeclient;
    private BigDecimal quantite;
    private BigDecimal prixunitaire;
}
