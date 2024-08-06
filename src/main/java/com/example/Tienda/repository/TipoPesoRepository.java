package com.example.Tienda.repository;

import com.example.Tienda.entity.CategoriaProducto;
import com.example.Tienda.entity.TipoPeso;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoPesoRepository extends ListCrudRepository<TipoPeso, Long> {
    List<TipoPeso> findByEstado(Boolean estado);
}
