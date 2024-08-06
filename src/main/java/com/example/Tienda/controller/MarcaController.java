package com.example.Tienda.controller;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    public MarcaService marcaService;

    @GetMapping
    public List<Marca> getAllMarca(){
        return marcaService.getAllMarca();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createMarca(@RequestBody Marca marca) {
        Map<String, String> response = new HashMap<>();
        try {
            Marca marcaRespuesta = marcaService.createMarca(marca);
            response.put("message", "Marca registrada con éxito");
            response.put("marca", marcaRespuesta.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Error al registrar la Marca: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteMarca(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        boolean isDeleted = marcaService.deleteMarca(id) == 1;
        if (isDeleted) {
            response.put("message", "Marca borrada correctamente.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Marca no encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



    @PostMapping("/editar")
    public ResponseEntity<Map<String, String>> updateMarca(@Validated @RequestBody Marca marca) {
        Map<String, String> response = new HashMap<>();

        // Verificar que el ID de la marca no sea nulo
        if (marca.getMarcaId() == null) {
            response.put("message", "Error: El ID de la marca no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Actualizar la marca
            Marca updatedMarca = marcaService.updateMarca(marca);
            if (updatedMarca != null) {
                response.put("message", "Marca actualizada con éxito con ID: " + updatedMarca.getMarcaId());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("message", "Error: No se encontró la marca con ID: " + marca.getMarcaId());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al actualizar la marca: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
