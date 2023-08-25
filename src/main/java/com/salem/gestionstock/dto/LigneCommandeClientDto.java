package com.salem.gestionstock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.CommandeClient;
import com.salem.gestionstock.model.LigneCommandeClient;
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

    @JsonIgnore
    private CommandeClientDto comandeclient;
    private BigDecimal quantite;
    private BigDecimal prixunitaire;

    private Integer identreprise;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if(ligneCommandeClient == null){
            return null;
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ligneCommandeClient.getArticle())
                .quantite(ligneCommandeClient.getQuantite())
                .prixunitaire(ligneCommandeClient.getPrixunitaire())
                .identreprise(ligneCommandeClient.getIdentreprise())
                .build();
    }
    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto == null){
            return null;
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setArticle(ligneCommandeClientDto.getArticle());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixunitaire(ligneCommandeClientDto.getPrixunitaire());
        ligneCommandeClient.setIdentreprise(ligneCommandeClientDto.getIdentreprise());
        return ligneCommandeClient;
    }
}
