package com.example.Tienda.service;

import com.example.Tienda.entity.Tienda;

import java.util.List;

public interface TiendaService {

    List<Tienda> getAllTienda();

    Tienda createTienda(Tienda tienda);

    void deleteTienda(Long id);

    Tienda updateTienda(Tienda tienda);
}
