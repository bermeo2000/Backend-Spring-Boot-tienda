package com.example.Tienda.controller;

import com.example.Tienda.entity.Tienda;
import com.example.Tienda.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tiendas")
public class TiendaController {

    @Autowired
    public TiendaService tiendaService;

    @GetMapping
    public List<Tienda> getAllTienda(){
        return tiendaService.getAllTienda();
    }

    @PostMapping
    public ResponseEntity<String> createTienda(@RequestBody Tienda tienda) {
        try {
            Tienda tiendaRespuesta = tiendaService.createTienda(tienda);
            return new ResponseEntity<>("Tienda registrada con éxito: " + tiendaRespuesta.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al registrar la Tienda: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTienda(@PathVariable Long id) {
        try {
            tiendaService.deleteTienda(id);
            return new ResponseEntity<>("Tienda eliminada", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("No existe la tienda con id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/editar")
    public ResponseEntity<String> updateTienda(@RequestBody Tienda tienda) {
        if (tienda.getTiendaId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error: El ID de la tienda no puede ser nulo.");
        }
        Tienda updatedTienda = tiendaService.updateTienda(tienda);
        if (updatedTienda != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Tienda actualizada con éxito con ID: " + updatedTienda.getTiendaId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: No se encontró la tienda con ID: " + tienda.getTiendaId());
        }
    }

}
