package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salem.gestionstock.utils.Constants.App_Root;

@Api(App_Root + "/commandeclient")
public interface CommandeClientApi {
    @PostMapping(App_Root + "/commandeclient/create")
   ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto commandeClientDto);
    @GetMapping(App_Root + "/commandeclient/{idcommande}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable("idcommande") Integer id);
    @GetMapping(App_Root + "/commandeclient/{codeCommande}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable String codeCommande);
    @GetMapping(App_Root + "/commandeclient/all")
    ResponseEntity<List<CommandeClientDto>> findAll();
    @DeleteMapping(App_Root + "/commandeclient/delete/{idCommande}")
    ResponseEntity delete(@PathVariable("idCommande") Integer id);
}
