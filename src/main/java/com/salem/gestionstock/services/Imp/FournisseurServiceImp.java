package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.FournisseurDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.repository.FournisseurRepository;
import com.salem.gestionstock.services.FournisseurService;
import com.salem.gestionstock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImp implements FournisseurService {
    FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImp(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {

        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if(!errors.isEmpty()){
            log.error("Fournisseur is not valide");
            throw new InvalidEntityException("Fournisseur is not valid", ErrorCodes.FOURNISSEUR_NOUT_FOUND,errors);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null){
            log.error("id is null");
            return null;
        }
        return fournisseurRepository.findById(id).map(FournisseurDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("Aucun fournisseur avec"+id+"comme id",ErrorCodes.FOURNISSEUR_NOUT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream().map(FournisseurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("id is null");
        }
        fournisseurRepository.deleteById(id);
    }
}
