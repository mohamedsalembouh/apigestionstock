package com.salem.gestionstock.controllers;

import com.salem.gestionstock.controllers.api.CommandeFournisseurApi;
import com.salem.gestionstock.dto.CommandeFournisseurDto;
import com.salem.gestionstock.services.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {
    CommandeFournisseurService commandeFournisseurService;
    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        return commandeFournisseurService.save(commandeFournisseurDto);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
     commandeFournisseurService.delete(id);
    }
}
