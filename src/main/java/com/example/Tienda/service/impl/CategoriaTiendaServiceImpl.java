package com.example.Tienda.service.impl;

import com.example.Tienda.entity.CategoriaTienda;
import com.example.Tienda.entity.Marca;
import com.example.Tienda.repository.CategoriaTiendaRepository;
import com.example.Tienda.service.CategoriaTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaTiendaServiceImpl implements CategoriaTiendaService {

    @Autowired
    public CategoriaTiendaRepository categoriaTiendaRepository;

    @Override
    public List<CategoriaTienda> getAllCategoriaTienda() {
        List<CategoriaTienda> allMarcas = categoriaTiendaRepository.findAll();
        return allMarcas.stream().filter(CategoriaTienda::getEstado).collect(Collectors.toList());
    }

    @Override
    public CategoriaTienda createCategoriaTienda(CategoriaTienda categoriaTienda) {
        return categoriaTiendaRepository.save(categoriaTienda);
    }

    public void deleteCategoriaTiendas(Long id) {
        Optional<CategoriaTienda> categoriaTiendaOptional = categoriaTiendaRepository.findById(id);
        if (categoriaTiendaOptional.isPresent()) {
            CategoriaTienda categoriaTienda = categoriaTiendaOptional.get();
            categoriaTienda.setEstado(false);
            categoriaTiendaRepository.save(categoriaTienda);
        } else {
            throw new RuntimeException("Categoría de tienda no encontrada con id " + id);
        }
    }

    @Override
    public int deleteCategoriaTienda(Long id) {
        CategoriaTienda categoriaTienda = findById(id);
        if (categoriaTienda != null) {
            categoriaTienda.setEstado(false);
            categoriaTiendaRepository.save(categoriaTienda);
            return 1;
        }
        return 0;
    }

    @Override
    public CategoriaTienda findById(Long id) {
        return categoriaTiendaRepository.findById(id).orElse(null);
    }


    @Override
    public CategoriaTienda UpdateCategoriaTienda(CategoriaTienda categoriaTienda) {
        Optional<CategoriaTienda> existingCategoriaTienda = categoriaTiendaRepository.findById(categoriaTienda.getTiendaCategoriaId());
        if (existingCategoriaTienda.isPresent()) {
            return categoriaTiendaRepository.save(categoriaTienda);
        } else {
            return null;
        }
    }

}
