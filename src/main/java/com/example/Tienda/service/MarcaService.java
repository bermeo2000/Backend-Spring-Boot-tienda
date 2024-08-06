package com.example.Tienda.service;

import com.example.Tienda.entity.Marca;

import java.util.List;

public interface MarcaService {

    List<Marca> getAllMarca();

    Marca createMarca (Marca marca);

    int deleteMarca(Long id);
    Marca findById(Long id);

    Marca updateMarca(Marca marca);
}
