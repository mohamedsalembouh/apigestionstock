package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.LigneVenteDto;
import com.salem.gestionstock.dto.VentesDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.model.Article;
import com.salem.gestionstock.model.LigneVente;
import com.salem.gestionstock.model.Ventes;
import com.salem.gestionstock.repository.ArticleRepository;
import com.salem.gestionstock.repository.LigneVenteRepository;
import com.salem.gestionstock.repository.VentesRepository;
import com.salem.gestionstock.services.VentesService;
import com.salem.gestionstock.validator.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VentesServiceImp implements VentesService {
    VentesRepository ventesRepository;
    ArticleRepository articleRepository;
    LigneVenteRepository ligneVenteRepository;
    @Override
    public VentesDto save(VentesDto ventesDto) {
        List<String> errors = VentesValidator.validate(ventesDto);
        if(!errors.isEmpty()){
            log.error("invalid vente");
            throw new InvalidEntityException("invalid vente", ErrorCodes.VENTES_NOT_FOUND,errors);
        }
        List<String> articleErrors = new ArrayList<>();
        if(ventesDto.getLigneVenteDtos() != null){
            ventesDto.getLigneVenteDtos().forEach(lignevente -> {
                if(lignevente.getArticleDto()!= null){
                    Optional<Article> article = articleRepository.findById(lignevente.getArticleDto().getId());
                    if(article.isEmpty()){
                      articleErrors.add("article not existe in db");
                    }
                }else{
                    articleErrors.add("could not insert vent without article");
                }
            });
        }
        if(!articleErrors.isEmpty()){
            throw new InvalidEntityException("article not existe",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
        }
        Ventes savedvente = ventesRepository.save(VentesDto.toEntity(ventesDto));
        ventesDto.getLigneVenteDtos().forEach(lignvnt -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(lignvnt);
            ligneVente.setVente(savedvente);
            ligneVenteRepository.save(ligneVente);
        });
        return VentesDto.fromEntity(savedvente);
    }

    @Override
    public VentesDto findById(Integer id) {
        if(id == null){
            return null;
        }
        return ventesRepository.findById(id).map(VentesDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("vente not found", ErrorCodes.VENTES_NOT_FOUND)
        );
    }

    @Override
    public VentesDto findByCode(String code) {
        if(StringUtils.hasLength(code)){
            return null;
        }
        return ventesRepository.findByCode(code).map(VentesDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun entity avec ce id",ErrorCodes.VENTES_NOT_FOUND)
        );
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream().map(VentesDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
     if(id == null){
         return;
     }
     ventesRepository.deleteById(id);
    }
}
