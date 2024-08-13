package com.example.Tienda.service;

import com.example.Tienda.entity.Usuario;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    public Usuario obtenerUsuario(String username);
    public void eliminarUsuario(Long usuarioId);

    List<Usuario> getAllUsuario();

    Usuario createUsuario (Usuario usuario);

    Usuario findById(Long id);

    int deleteUsuario (Long id);

    Usuario updateUsuario (Usuario usuario);
}
