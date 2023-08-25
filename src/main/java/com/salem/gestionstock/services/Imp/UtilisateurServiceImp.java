package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.UtilisateurDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.repository.UtilisateurRepository;
import com.salem.gestionstock.services.UtilisateurService;
import com.salem.gestionstock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService {
    UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImp(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valide");
            throw new InvalidEntityException("Utilisateur is not valide", ErrorCodes.UTILISATEUR_NOT_FOUND,errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurRepository.findById(id).map(UtilisateurDto::fromEntity).orElseThrow(
                ()-> new EntityNotFoundException("Aucun utilisateur wit id = "+id+"n'a ete trouve",ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
     if(id == null){
         log.error("id is null");
     }
     utilisateurRepository.deleteById(id);
    }
}
