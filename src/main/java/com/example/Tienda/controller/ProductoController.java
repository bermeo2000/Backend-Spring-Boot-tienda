package com.example.Tienda.controller;

import com.example.Tienda.entity.Marca;
import com.example.Tienda.entity.Producto;
import com.example.Tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    public ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProducto() {
        return productoService.getAllProducto();
    }


    @PostMapping
    public ResponseEntity<Map<String, String>> createProducto(@RequestBody Producto producto  ) {
        Map<String, String> response = new HashMap<>();
        try {
            Producto productoRespuesta = productoService.createProducto(producto);
            response.put("message", "Producto registrado con éxito");
            response.put("producto", productoRespuesta.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            response.put("message", "Error al registrar el Producto: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProducto(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();

            boolean isDeleted = productoService.deleteProducto(id) == 1;
            if (isDeleted) {
                response.put("message", "Producto eliminado correctamente.");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Producto no encontrado con id " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }


    @PostMapping("/editar")
    public ResponseEntity<Map<String, String>> updateProducto(@Validated @RequestBody Producto producto) {
        Map<String, String> response = new HashMap<>();

        // Verificar que el ID del producto no sea nulo
        if (producto.getProductoId() == null) {
            response.put("message", "Error: El ID del producto no puede ser nulo.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Actualizar el producto
            Producto updatedProducto = productoService.updateProducto(producto);
            if (updatedProducto != null) {
                response.put("message", "Producto actualizado con éxito con ID: " + updatedProducto.getProductoId());
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                response.put("message", "Error: No se encontró el producto con ID: " + producto.getProductoId());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error al actualizar el producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
