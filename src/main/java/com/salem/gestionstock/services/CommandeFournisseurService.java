package com.salem.gestionstock.services;



import com.salem.gestionstock.dto.CommandeFournisseurDto;

import java.util.List;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto findById(Integer id);
    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);
}
