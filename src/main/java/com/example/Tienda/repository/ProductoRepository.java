package com.example.Tienda.repository;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.entity.Producto;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ListCrudRepository<Producto, Long> {
    List<Producto> findByEstado(Boolean estado);

}
