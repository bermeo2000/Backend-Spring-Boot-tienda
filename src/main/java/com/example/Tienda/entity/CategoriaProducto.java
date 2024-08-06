package com.example.Tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categorias_producto")
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_producto")
    private Long categoriaProductoId;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "estado")
    private Boolean estado = true;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_tienda")
    private Tienda idTienda;

    @Override
    public String toString() {
        return "CategoriaProducto{" +
                "categoriaProductoId=" + categoriaProductoId +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", idTienda=" + idTienda +
                '}';
    }
}
