package com.salem.gestionstock.controllers.api;

import com.salem.gestionstock.dto.VentesDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salem.gestionstock.utils.Constants.VENTES_ENDPOINT;

@Api(VENTES_ENDPOINT)
public interface VentesApi {
    @PostMapping(VENTES_ENDPOINT + "/create")
    VentesDto save(@RequestBody VentesDto ventesDto);
    @GetMapping(VENTES_ENDPOINT + "/{id}")
    VentesDto findById(@PathVariable Integer id);
    @GetMapping(VENTES_ENDPOINT + "/{code}")
    VentesDto findByCode(@PathVariable String code);
    @GetMapping(VENTES_ENDPOINT + "/all")
    List<VentesDto> findAll();
   @DeleteMapping(VENTES_ENDPOINT + "/{id}")
    void delete(Integer id);
}
