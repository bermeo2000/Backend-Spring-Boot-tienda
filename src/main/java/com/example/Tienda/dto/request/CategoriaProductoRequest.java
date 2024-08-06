package com.example.Tienda.dto.request;


import com.example.Tienda.entity.CategoriaProducto;
import com.example.Tienda.entity.Producto;

import java.io.Serializable;
import java.util.List;

public class CategoriaProductoRequest implements Serializable {

    private CategoriaProducto categoriaProducto;
    private List<Producto> productos;

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


}
