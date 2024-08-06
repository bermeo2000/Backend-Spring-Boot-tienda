package com.example.Tienda.service.impl;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.repository.MarcaRepository;
import com.example.Tienda.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    public MarcaRepository marcaRepository;
    @Override
    public List<Marca> getAllMarca() {
        List<Marca> allMarcas = marcaRepository.findAll();
        return allMarcas.stream().filter(Marca::getEstado).collect(Collectors.toList());
    }

    @Override
    public Marca createMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca findById(Long id) {
        return marcaRepository.findById(id).orElse(null);
    }


    @Override
    public int deleteMarca(Long id) {
        Marca marca = findById(id);
        if (marca != null) {
            marca.setEstado(false);
            marcaRepository.save(marca);
            return 1;
        }
        return 0;
    }


    @Override
    public Marca updateMarca(Marca marca) {
        Optional<Marca> existingMarca = marcaRepository.findById(marca.getMarcaId());
        if (existingMarca.isPresent()) {
            return marcaRepository.save(marca);
        } else {
            return null;
        }
    }
}
