package com.example.Tienda.service.impl;

import com.example.Tienda.entity.CategoriaProducto;
import com.example.Tienda.repository.CategoriaProductoRepository;
import com.example.Tienda.service.CategoriaProductoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaProductoServiceImpl implements CategoriaProductoService {

    @Autowired
    public CategoriaProductoRepository categoriaProductoRepository;

    @Override
    public List<CategoriaProducto> getAllCategoriaProducto() {
        return categoriaProductoRepository.findByEstado(true);
    }


    @Override
    @Transactional
    public CategoriaProducto createCategoriaProducto(CategoriaProducto categoriaProducto) {
        return categoriaProductoRepository.save(categoriaProducto);
    }

    @Override
    public int deleteCategoriaProducto(Long id) {
        CategoriaProducto categoriaProducto = findById(id);
        if (categoriaProducto != null) {
            categoriaProducto.setEstado(false);
            categoriaProductoRepository.save(categoriaProducto);
            return 1;
        }
        return 0;
    }

    @Override
    public CategoriaProducto updateCategoriaProducto(CategoriaProducto categoriaProducto) {
        Optional<CategoriaProducto> existingMarca = categoriaProductoRepository.findById(categoriaProducto.getCategoriaProductoId());
        if (existingMarca.isPresent()) {
            return categoriaProductoRepository.save(categoriaProducto);
        } else {
            return null;
        }
    }

    @Override
    public CategoriaProducto findById(Long id) {
        return categoriaProductoRepository.findById(id).orElse(null);
    }

}






