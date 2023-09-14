package com.salem.gestionstock.controllers;

import com.salem.gestionstock.controllers.api.VentesApi;
import com.salem.gestionstock.dto.VentesDto;
import com.salem.gestionstock.services.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class VentesController implements VentesApi {
    VentesService ventesService;
    @Autowired
    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    public VentesDto save(VentesDto ventesDto) {
        return ventesService.save(ventesDto);
    }

    @Override
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    public void delete(Integer id) {
     ventesService.delete(id);
    }
}
