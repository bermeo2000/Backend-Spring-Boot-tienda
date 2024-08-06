package com.example.Tienda.service;

import com.example.Tienda.entity.CategoriaProducto;
import com.example.Tienda.entity.Marca;

import java.util.List;

public interface CategoriaProductoService {
    List<CategoriaProducto> getAllCategoriaProducto();

    CategoriaProducto createCategoriaProducto(CategoriaProducto categoriaProducto);

    int deleteCategoriaProducto(Long id);

    CategoriaProducto updateCategoriaProducto(CategoriaProducto categoriaProducto);

    CategoriaProducto findById(Long id);
}
