package com.salem.gestionstock.services;



import com.salem.gestionstock.dto.VentesDto;

import java.util.List;

public interface VentesService {
    VentesDto save(VentesDto ventesDto);

    VentesDto findById(Integer id);

    VentesDto findByCode(String code);

    List<VentesDto> findAll();

    void delete(Integer id);
}
