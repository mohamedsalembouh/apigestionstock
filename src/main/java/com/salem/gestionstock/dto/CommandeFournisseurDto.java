package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.CommandeFournisseur;
import com.salem.gestionstock.model.Fournisseur;
import com.salem.gestionstock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {
    private int id;
    private String code;
    private Instant dateComand;

    private FournisseurDto fournisseur;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    private Integer identreprise;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateComand(commandeFournisseur.getDateComand())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .identreprise(commandeFournisseur.getIdentreprise())
                .build();
    }
    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null){
            return null;
        }
        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateComand(commandeFournisseurDto.getDateComand());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));
        commandeFournisseur.setIdentreprise(commandeFournisseurDto.getIdentreprise());
        return commandeFournisseur;
    }
}
