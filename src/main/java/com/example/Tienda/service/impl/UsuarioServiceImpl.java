package com.example.Tienda.service.impl;

import com.example.Tienda.entity.Usuario;
import com.example.Tienda.repository.UsuarioRepository;
import com.example.Tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Usuario obtenerUsuario(String username) {
        return null;
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<Usuario> allUsuario = usuarioRepository.findAll();
        return allUsuario.stream().filter(Usuario::getEstado).collect(Collectors.toList());
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }


    @Override
    public int deleteUsuario(Long id) {
        Usuario usuario = findById(id);
        if (usuario != null) {
            usuario.setEstado(false);
            usuarioRepository.save(usuario);
            return 1;
        }
        return 0;
    }


    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(usuario.getUsuarioId());
        if (existingUsuario.isPresent()) {
            return usuarioRepository.save(usuario);
        } else {
            return null;
        }
    }
}
