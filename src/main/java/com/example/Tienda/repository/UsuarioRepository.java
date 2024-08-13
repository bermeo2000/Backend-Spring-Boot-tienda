package com.example.Tienda.repository;

import com.example.Tienda.entity.Usuario;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends ListCrudRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
