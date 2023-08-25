package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.CommandeClientDto;
import com.salem.gestionstock.dto.LigneCommandeClientDto;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.Client;
import com.salem.gestionstock.model.CommandeClient;
import com.salem.gestionstock.model.LigneCommandeClient;
import com.salem.gestionstock.repository.ArticleRepository;
import com.salem.gestionstock.repository.ClientRepository;
import com.salem.gestionstock.repository.CommandeClientRepository;
import com.salem.gestionstock.repository.LigneCommandeClientRepository;
import com.salem.gestionstock.services.CommandeClientService;
import com.salem.gestionstock.validator.CommandeClientValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeClientServiceImp implements CommandeClientService {
    CommandeClientRepository commandeClientRepository;
    ClientRepository clientRepository;
    ArticleRepository articleRepository;
    LigneCommandeClientRepository ligneCommandeClientRepository;
   @Autowired
    public CommandeClientServiceImp(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
       List<String> errors = CommandeClientValidator.validate(commandeClientDto);
       if(!errors.isEmpty()){
           log.error("commandclient not valide");
           throw new InvalidEntityException("commande client not valide", ErrorCodes.COMMANDE_CLIENT_NOT_FOUNDE,errors);
       }
        Optional<Client> client = clientRepository.findById(commandeClientDto.getClient().getId());
       if(client.isEmpty()){
           throw new EntityNotFoundException("client not found in db");
       }
       List<String> errorArticles = new ArrayList<>();
       if(commandeClientDto.getLigneCommandeClient() != null){
           commandeClientDto.getLigneCommandeClient().forEach(lignecmdclt ->{
                      if(lignecmdclt.getArticle() != null){
                          Optional<Article> article = articleRepository.findById(lignecmdclt.getArticle().getId());
                          if(article.isEmpty()){
                              errorArticles.add("no article with id = "+lignecmdclt.getArticle().getId()+"existe in dbb");
                          }
                      }else{
                          errorArticles.add("impossible d'enregistrer une commande avec un article null");
                      }
                   }
           );
       }

       if(!errorArticles.isEmpty()){
           log.error("article not valide");
           throw new InvalidEntityException("article not found",ErrorCodes.ARTICLE_NOT_FOUND,errorArticles);
       }
        CommandeClient savedcommandeClient = commandeClientRepository.save(CommandeClientDto.toEntity(commandeClientDto));
       commandeClientDto.getLigneCommandeClient().forEach(lignecmdclt -> {
           LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(lignecmdclt);
           ligneCommandeClient.setComandeclient(savedcommandeClient);
           ligneCommandeClientRepository.save(ligneCommandeClient);
       });

        return CommandeClientDto.fromEntity(savedcommandeClient);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
       if(id == null){
           log.error("id is null");
           return null;
       }
        return commandeClientRepository.findById(id)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Aucun commandclient with id = "+id+"n'a ete trouve")
                );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
       if(!StringUtils.hasLength(code)){
           log.error("code is null");
           return null;
       }
        return commandeClientRepository.findByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Aucun entity with code = "+code+"n'a ete trouve")
                );
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream().map(CommandeClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
     if(id == null){
         log.error("id is null");
     }
     commandeClientRepository.deleteById(id);
    }
}
