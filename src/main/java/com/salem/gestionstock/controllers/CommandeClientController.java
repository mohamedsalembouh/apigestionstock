package com.salem.gestionstock.controllers;

import com.salem.gestionstock.controllers.api.CommandeClientApi;
import com.salem.gestionstock.dto.CommandeClientDto;
import com.salem.gestionstock.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeClientController implements CommandeClientApi {
  CommandeClientService commandeClientService;
  @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }

    @Override
    public ResponseEntity<CommandeClientDto> save(CommandeClientDto commandeClientDto) {
        return ResponseEntity.ok(commandeClientService.save(commandeClientDto));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findById(Integer id) {
        return ResponseEntity.ok(commandeClientService.findById(id));
    }

    @Override
    public ResponseEntity<CommandeClientDto> findByCode(String codeCommande) {
        return ResponseEntity.ok(commandeClientService.findByCode(codeCommande));
    }

    @Override
    public ResponseEntity<List<CommandeClientDto>> findAll() {
        return ResponseEntity.ok(commandeClientService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
      commandeClientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
