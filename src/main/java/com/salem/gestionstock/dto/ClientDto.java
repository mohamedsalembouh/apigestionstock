package com.salem.gestionstock.dto;

import com.salem.gestionstock.model.Adresse;
import com.salem.gestionstock.model.Client;
import com.salem.gestionstock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {
    private int id;
    private String nom;
    private String prenom;
    private Adresse adress;
    private String photo;
    private String mail;
    private String numTel;
    private List<CommandeClientDto> commandeClient;

    public ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }
        return  ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adress(client.getAdress())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .build();
    }
    public Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return null;
        }
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdress(clientDto.getAdress());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        return client;
    }
}
