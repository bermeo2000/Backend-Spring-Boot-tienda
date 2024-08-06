package com.example.Tienda.repository;

import com.example.Tienda.entity.Marca;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends ListCrudRepository<Marca, Long> {
    List<Marca> findByEstado(Boolean estado);
}
