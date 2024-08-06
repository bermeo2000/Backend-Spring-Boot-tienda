package com.example.Tienda.service;

import com.example.Tienda.entity.Usuario;
import com.example.Tienda.entity.UsuarioRol;

import java.util.List;
import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String nombreUsuario);

    List<Usuario> getAllUsuario();

    Usuario createUsuario (Usuario usuario);

    Usuario findById(Long id);

    int deleteUsuario (Long id);

    Usuario updateUsuario (Usuario usuario);
}
