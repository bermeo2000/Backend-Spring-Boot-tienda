package com.example.Tienda.service.impl;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.entity.Producto;
import com.example.Tienda.repository.ProductoRepository;
import com.example.Tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    public ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProducto() {
       return productoRepository.findByEstado(true);

    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public int deleteProducto(Long id) {
        Producto producto = findById(id);
        if (producto != null) {
            producto.setEstado(false);
            productoRepository.save(producto);
            return 1;
        }
        return 0;
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Optional<Producto> existingProducto = productoRepository.findById(producto.getProductoId());
        if (existingProducto.isPresent()) {
            return productoRepository.save(producto);
        } else {
            return null;
        }
    }
}
