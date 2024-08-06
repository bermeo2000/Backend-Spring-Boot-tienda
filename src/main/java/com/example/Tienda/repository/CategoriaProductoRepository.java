package com.example.Tienda.repository;

import com.example.Tienda.entity.CategoriaProducto;
import com.example.Tienda.entity.Marca;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaProductoRepository extends ListCrudRepository<CategoriaProducto, Long> {
    List<CategoriaProducto> findByEstado(Boolean estado);
}
