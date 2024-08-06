package com.example.Tienda.service;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.entity.TipoPeso;

import java.util.List;

public interface TipoPesoService {

    List<TipoPeso> getAllTipoPeso();

    TipoPeso createtipoPeso (TipoPeso tipoPeso);

    int deleteTipoPeso(Long id);

    TipoPeso findById(Long id);

    TipoPeso updatetipoPeso (TipoPeso tipoPeso);
}
