package com.example.Tienda.service.impl;

import com.example.Tienda.entity.Tienda;
import com.example.Tienda.repository.TiendaRepository;
import com.example.Tienda.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    public TiendaRepository tiendaRepository;

    @Override
    public List<Tienda> getAllTienda() {
        return tiendaRepository.findAll();
    }

    @Override
    public Tienda createTienda(Tienda tienda) {
        return tiendaRepository.save(tienda);
    }

    @Override
    public void deleteTienda(Long id) {
        Optional<Tienda> tiendaOptional = tiendaRepository.findById(id);
        if (tiendaOptional.isPresent()) {
            Tienda tienda = tiendaOptional.get();
            tienda.setEstado(false); // Cambia el estado a false para eliminación lógica
            tiendaRepository.save(tienda);
        } else {
            throw new RuntimeException("Tienda not found with id " + id);
        }
    }

    @Override
    public Tienda updateTienda(Tienda tienda) {
        Optional<Tienda> existingTienda = tiendaRepository.findById(tienda.getTiendaId());
        if (existingTienda.isPresent()) {
            return tiendaRepository.save(tienda);
        } else {
            return null;
        }
    }

}
