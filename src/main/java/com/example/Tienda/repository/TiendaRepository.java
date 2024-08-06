package com.example.Tienda.repository;

import com.example.Tienda.entity.Tienda;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepository extends ListCrudRepository<Tienda, Long> {
}
