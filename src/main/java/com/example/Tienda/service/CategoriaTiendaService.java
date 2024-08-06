package com.example.Tienda.service;

import com.example.Tienda.entity.CategoriaTienda;
import com.example.Tienda.entity.Marca;

import java.util.List;

public interface CategoriaTiendaService {
    List<CategoriaTienda> getAllCategoriaTienda();

    CategoriaTienda createCategoriaTienda(CategoriaTienda categoriaTienda);

    int deleteCategoriaTienda(Long id);
    CategoriaTienda findById(Long id);

    CategoriaTienda UpdateCategoriaTienda(CategoriaTienda categoriaTienda);

}
