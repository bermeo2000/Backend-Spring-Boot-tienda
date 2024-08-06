package com.example.Tienda.repository;

import com.example.Tienda.entity.Usuario;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends ListCrudRepository<Usuario, Long> {
    public Usuario findAllByNombreUsuario(String nombreUsuario);
}
