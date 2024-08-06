package com.example.Tienda.service.impl;

import com.example.Tienda.entity.CategoriaTienda;
import com.example.Tienda.entity.Marca;
import com.example.Tienda.entity.TipoPeso;
import com.example.Tienda.repository.TipoPesoRepository;
import com.example.Tienda.service.TipoPesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoPesoServiceImpl implements TipoPesoService {

    @Autowired
    public TipoPesoRepository tipoPesoRepository;
    public List<TipoPeso> getAllTipoPeso() {
        return tipoPesoRepository.findByEstado(true);
    }

    @Override
    public TipoPeso createtipoPeso(TipoPeso tipoPeso) {
        return tipoPesoRepository.save(tipoPeso);
    }

    @Override
    public int deleteTipoPeso(Long id) {
        TipoPeso TipoPeso = findById(id);
        if (TipoPeso != null) {
            TipoPeso.setEstado(false);
            tipoPesoRepository.save(TipoPeso);
            return 1;
        }
        return 0;
    }

    @Override
    public TipoPeso findById(Long id) {
        return tipoPesoRepository.findById(id).orElse(null);
    }

    @Override
    public TipoPeso updatetipoPeso(TipoPeso tipoPeso) {
        Optional<TipoPeso> existingMarca = tipoPesoRepository.findById(tipoPeso.getPesoTipoId());
        if (existingMarca.isPresent()) {
            return tipoPesoRepository.save(tipoPeso);
        } else {
            return null;
        }
    }
}
