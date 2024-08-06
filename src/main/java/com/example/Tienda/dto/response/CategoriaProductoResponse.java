package com.example.Tienda.dto.response;

import com.example.Tienda.entity.Tienda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProductoResponse {

    private Long id;
    private String descripcion;
    private Boolean estado;
    private Tienda idTienda;
}
