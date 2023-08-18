package com.salem.gestionstock.dto;

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
}
