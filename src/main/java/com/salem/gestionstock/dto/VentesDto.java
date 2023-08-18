package com.salem.gestionstock.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VentesDto {
    private int id;
    private String code;
    private Instant dateVente;

    private String commentaire;
}
