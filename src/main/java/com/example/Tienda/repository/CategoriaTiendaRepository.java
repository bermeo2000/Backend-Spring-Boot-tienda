package com.example.Tienda.repository;

import com.example.Tienda.entity.CategoriaTienda;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaTiendaRepository extends ListCrudRepository<CategoriaTienda, Long > {
    List<CategoriaTienda> findByEstado(Boolean estado);
}
