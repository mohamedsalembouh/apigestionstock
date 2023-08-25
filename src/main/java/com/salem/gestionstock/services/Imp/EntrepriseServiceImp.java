package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.EntrepriseDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.repository.EntrepriseRepository;
import com.salem.gestionstock.services.EntrepriseService;
import com.salem.gestionstock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImp implements EntrepriseService {
    EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImp(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors = EntrepriseValidator.validate(entrepriseDto);
        if(!errors.isEmpty()){
            log.error("Entreprise is not valide ");
            throw new InvalidEntityException("Entreprise is not valide", ErrorCodes.ENTREPRISE_NOT_FOUND,errors);
        }
        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(entrepriseDto)));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null){
            log.error("id is null");
            return null;
        }
        return entrepriseRepository.findById(id).map(EntrepriseDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun entreprise avec id = "+id+"n'a ete trouve",ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream().map(EntrepriseDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
     if(id == null){
         log.error("id is null");
     }
     entrepriseRepository.deleteById(id);
    }
}
