package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.LigneVente;
import com.salem.gestionstock.model.Ventes;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private int id;
    private VentesDto vente;
    private BigDecimal quantite;
    private BigDecimal prixunitaire;
    private ArticleDto articleDto;

    private Integer identreprise;
    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return null;
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixunitaire(ligneVente.getPrixunitaire())
                .articleDto(ArticleDto.fromEntity(ligneVente.getArticle()))
                .identreprise(ligneVente.getIdentreprise())
                .build();
    }
    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null){
            return null;
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixunitaire(ligneVenteDto.getPrixunitaire());
        ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticleDto()));
        ligneVente.setIdentreprise(ligneVenteDto.getIdentreprise());
        return ligneVente;
    }
}
