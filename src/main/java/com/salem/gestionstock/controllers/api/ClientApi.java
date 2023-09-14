package com.salem.gestionstock.controllers.api;


import com.salem.gestionstock.dto.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.salem.gestionstock.utils.Constants.App_Root;

@Api(App_Root + "/client")
public interface ClientApi {
    @PostMapping(value = App_Root +"/client/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto clientDto);
    @GetMapping(value = App_Root +"/Client/{idClient}",produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idClient") Integer id);
    @GetMapping(value = App_Root +"/Client/all",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();
    @DeleteMapping(value = App_Root + "/Client/delete/{idClient}")
    void delete(@PathVariable("idClient") Integer id);

}
