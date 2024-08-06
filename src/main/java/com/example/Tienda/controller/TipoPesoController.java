package com.example.Tienda.controller;

import com.example.Tienda.entity.TipoPeso;
import com.example.Tienda.service.TipoPesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tipoPesos")
public class TipoPesoController {

    @Autowired
    public TipoPesoService tipoPesoService;

    @GetMapping
    public List<TipoPeso> getAllTipoPeso(){
        return  tipoPesoService.getAllTipoPeso();
    }

    @PostMapping()
    public ResponseEntity<Map<String, String>> createTipoPeso(@RequestBody TipoPeso tipoPeso) {
        Map<String, String> response = new HashMap<>();
        try {
            TipoPeso tipoPesoRespuesta = tipoPesoService.createtipoPeso(tipoPeso);
            response.put("message", "Tipo peso registrado con éxito");
            response.put("tipoPeso", tipoPesoRespuesta.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Error al registrar el Tipo Peso: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteTipoPeso(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        boolean isDeleted = tipoPesoService.deleteTipoPeso(id) ==1;
        if (isDeleted) {
            response.put("message", "TipoPeso borrada correctamente.");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "TipoPeso no encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/editar")
    public ResponseEntity<Map<String, String>> updateTipoPeso(@Validated @RequestBody TipoPeso tipoPeso) {
        Map<String, String> response = new HashMap<>();

        // Verificar que el ID del TipoPeso no sea nulo
        if (tipoPeso.getPesoTipoId() == null) {
            response.put("message", "Error: El ID del TipoPeso no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Actualizar el TipoPeso
            TipoPeso tipoPesoRespuesta = tipoPesoService.updatetipoPeso(tipoPeso);
            if (tipoPesoRespuesta != null) {
                response.put("message", "TipoPeso actualizado con éxito con ID: " + tipoPesoRespuesta.getPesoTipoId());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("message", "Error: No se encontró el TipoPeso con ID: " + tipoPeso.getPesoTipoId());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al actualizar el TipoPeso: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}

