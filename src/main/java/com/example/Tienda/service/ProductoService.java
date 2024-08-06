package com.example.Tienda.service;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAllProducto();

    Producto createProducto(Producto producto);

    int deleteProducto(Long id);

    Producto findById(Long id);

    Producto updateProducto(Producto producto);
}
