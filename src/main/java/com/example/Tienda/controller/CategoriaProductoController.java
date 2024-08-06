package com.example.Tienda.controller;

import com.example.Tienda.entity.CategoriaProducto;
import com.example.Tienda.service.CategoriaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categoriaProductos")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoService categoriaProductoService;

    @GetMapping
    public List<CategoriaProducto> getAllCategoriaProducto(){
        return categoriaProductoService.getAllCategoriaProducto();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createCategoriaProducto(@RequestBody CategoriaProducto categoriaProducto) {
        Map<String, String> response = new HashMap<>();
        try {
            CategoriaProducto categoriaProductoRespuesta = categoriaProductoService.createCategoriaProducto(categoriaProducto);
            response.put("message", "Categoría de producto registrada con éxito");
            response.put("categoriaProducto", categoriaProductoRespuesta.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Error al registrar la categoría de producto: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCategoriaProducto(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        try {
            categoriaProductoService.deleteCategoriaProducto(id);
            response.put("message", "Categoría de producto eliminada con éxito");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al eliminar la categoría de producto: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PostMapping("/editar")
    public ResponseEntity<Map<String, String>> updateCategoriaProducto(@Validated @RequestBody CategoriaProducto categoriaProducto) {
        Map<String, String> response = new HashMap<>();

        // Verificar que el ID de la categoría de producto no sea nulo
        if (categoriaProducto.getCategoriaProductoId() == null) {
            response.put("message", "Error: El ID de la categoría de producto no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Actualizar la categoría de producto
            CategoriaProducto updatedCategoriaProducto = categoriaProductoService.updateCategoriaProducto(categoriaProducto);
            if (updatedCategoriaProducto != null) {
                response.put("message", "Categoría de producto actualizada con éxito con ID: " + updatedCategoriaProducto.getCategoriaProductoId());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("message", "Error: No se encontró la categoría de producto con ID: " + categoriaProducto.getCategoriaProductoId());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al actualizar la categoría de producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

}
