package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Ventes;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class VentesDto {
    private int id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private List<LigneVenteDto> ligneVenteDtos;

    private Integer identreprise;

    public static VentesDto fromEntity(Ventes ventes){
        if(ventes == null){
            return null;
        }
        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .identreprise(ventes.getIdentreprise())
                .build();
    }
    public static Ventes toEntity(VentesDto ventesDto){
        if(ventesDto == null){
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());
        ventes.setIdentreprise(ventesDto.getIdentreprise());
        return ventes;
    }

}
