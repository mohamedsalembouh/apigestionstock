package com.salem.gestionstock.controllers;

import com.salem.gestionstock.controllers.api.ClientApi;
import com.salem.gestionstock.dto.ClientDto;
import com.salem.gestionstock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientController implements ClientApi {
    ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
      clientService.delete(id);
    }
}
