package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Client;
import com.salem.gestionstock.model.CommandeClient;
import com.salem.gestionstock.model.LigneCommandeClient;
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
public class CommandeClientDto {
    private int id;
    private String code;
    private Instant dateComande;

    private ClientDto client;
    private List<LigneCommandeClientDto> ligneCommandeClient;

    public CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient == null){
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateComande(commandeClient.getDateComande())
                .build();
    }
    public CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null){
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateComande(commandeClientDto.getDateComande());
        return  commandeClient;
    }
}
