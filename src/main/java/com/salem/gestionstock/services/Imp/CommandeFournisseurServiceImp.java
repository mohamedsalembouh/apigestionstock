package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.CommandeFournisseurDto;
import com.salem.gestionstock.dto.LigneCommandeFournisseurDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.CommandeFournisseur;
import com.salem.gestionstock.model.Fournisseur;
import com.salem.gestionstock.model.LigneCommandeFournisseur;
import com.salem.gestionstock.repository.*;
import com.salem.gestionstock.services.CommandeFournisseurService;
import com.salem.gestionstock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommandeFournisseurServiceImp implements CommandeFournisseurService {
    CommandeFournisseurRepository commandeFournisseurRepository;
    FournisseurRepository fournisseurRepository;
    ArticleRepository articleRepository;
    LigneCommandeFournisseurRepository ligneCommandefournisseurRepository;
    @Autowired
    public CommandeFournisseurServiceImp(CommandeFournisseurRepository commandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository, LigneCommandeFournisseurRepository ligneCommandefournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandefournisseurRepository = ligneCommandefournisseurRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors = CommandeFournisseurValidator.validate(commandeFournisseurDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("invalid commande", ErrorCodes.LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND,errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(commandeFournisseurDto.getFournisseur().getId());
        if(fournisseur.isEmpty()){
            throw new EntityNotFoundException("fournisseur n'existe pas in db");
        }
        List<String> articleErrors = new ArrayList<>();
        if(commandeFournisseurDto.getLigneCommandeFournisseurs() != null){
            commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(lignecmdfrs -> {
               if(lignecmdfrs.getArticle() != null){
                   Optional<Article> article = articleRepository.findById(lignecmdfrs.getArticle().getId());
                   if(article.isEmpty()){
                       articleErrors.add("article n'existe pas in db");
                   }else {
                       articleErrors.add("can not add commande with article null");
                   }
               }
            });
        }
        if(!articleErrors.isEmpty()){
            throw new InvalidEntityException("article is not valide");
        }
        CommandeFournisseur savedCommandeFournisseur = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(commandeFournisseurDto));
        commandeFournisseurDto.getLigneCommandeFournisseurs().forEach(ligneCmdfrs -> {
            LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligneCmdfrs);
            ligneCommandeFournisseur.setCommandeFournisseur(savedCommandeFournisseur);
            ligneCommandefournisseurRepository.save(ligneCommandeFournisseur);
        });
        return CommandeFournisseurDto.fromEntity(savedCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id == null){
            log.error("id is null");
            return null;
        }
        return commandeFournisseurRepository.findById(id).map(CommandeFournisseurDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun commandefournisseur avec id = "+id+"n'a ete trouve",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurRepository.findByCode(code).map(CommandeFournisseurDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun commande avec code = "+code,ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream().map(CommandeFournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
  if(id == null){
      log.error("id is null");
      return;
  }
  commandeFournisseurRepository.deleteById(id);
    }
}
