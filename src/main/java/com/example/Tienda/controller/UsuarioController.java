package com.example.Tienda.controller;

import com.example.Tienda.entity.Rol;
import com.example.Tienda.entity.Usuario;
import com.example.Tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    public UsuarioService usuarioService;

    //Mostrar los que estan en angular
    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioService.getAllUsuario();
    }


    @PostMapping
    public ResponseEntity<Map<String, String>> createUsuario(@RequestBody Usuario usuario) {
        Map<String, String> response = new HashMap<>();
        try {
            Usuario usuarioCreado = usuarioService.createUsuario(usuario);
            response.put("message", "Usuario registrado con éxito");
            response.put("usuario", usuarioCreado.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Error al registrar el Usuario: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/editar")
    public ResponseEntity<Map<String, String>> updateUsuario(@Validated @RequestBody Usuario usuario) {
        Map<String, String> response = new HashMap<>();

        // Verificar que el ID del usuario no sea nulo
        if (usuario.getUsuarioId() == null) {
            response.put("message", "Error: El ID del Usuario no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Actualizar el usuario
            Usuario usuarioRespuesta = usuarioService.updateUsuario(usuario);
            if (usuarioRespuesta != null) {
                response.put("message", "Usuario actualizado con éxito con ID: " + usuarioRespuesta.getUsuarioId());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("message", "Error: No se encontró el Usuario con ID: " + usuario.getUsuarioId());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al actualizar el Usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUsuario(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        boolean isDeleted = usuarioService.deleteUsuario(id) == 1;
        if (isDeleted) {
            response.put("message", "Marca borrada correctamente.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Marca no encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}





