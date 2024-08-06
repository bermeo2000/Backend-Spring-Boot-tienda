package com.example.Tienda.controller;


import com.example.Tienda.entity.CategoriaTienda;
import com.example.Tienda.service.CategoriaTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categoriaTiendas")
public class CategoriaTiendaController {

    @Autowired
    public CategoriaTiendaService categoriaTiendaService;

    @GetMapping
    public List<CategoriaTienda> getAllCategoriaTienda(){
        return categoriaTiendaService.getAllCategoriaTienda();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createCategoriaTienda(@RequestBody CategoriaTienda categoriaTienda) {
        Map<String, String> response = new HashMap<>();
        try {
            CategoriaTienda categoriaTiendaRespuesta = categoriaTiendaService.createCategoriaTienda(categoriaTienda);
            response.put("message", "Categoría de tienda registrada con éxito.");
            response.put("categoriaTiendaId", categoriaTiendaRespuesta.getTiendaCategoriaId().toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Error al registrar la categoría de tienda: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCategoriaTienda(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        boolean isDeleted = categoriaTiendaService.deleteCategoriaTienda(id) == 1;
        if (isDeleted) {
            response.put("message", "Categoría de tienda borrada correctamente.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Categoría de tienda no encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @PostMapping("/editar")
    public ResponseEntity<Map<String, String>> updateCategoriaTienda(@RequestBody CategoriaTienda categoriaTienda) {
        Map<String, String> response = new HashMap<>();

        // Verificar que el ID de la categoría de tienda no sea nulo
        if (categoriaTienda.getTiendaCategoriaId() == null) {
            response.put("message", "Error: El ID de la categoría de tienda no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            CategoriaTienda updatedCategoriaTienda = categoriaTiendaService.UpdateCategoriaTienda(categoriaTienda);
            if (updatedCategoriaTienda != null) {
                response.put("message", "Categoría de tienda actualizada con éxito con ID: " + updatedCategoriaTienda.getTiendaCategoriaId());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("message", "Error: No se encontró la categoría de tienda con ID: " + categoriaTienda.getTiendaCategoriaId());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al actualizar la categoría de tienda: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
