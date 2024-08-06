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
@Table(name = "productos")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long productoId;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "precio")
    private Double precio;

    @NotNull
    @Column(name = "peso")
    private Float peso;

    @Lob
    @NotNull

    @Column(name = "imagen")
    private String imagen;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "estado")
    private Boolean estado= true;

    @ManyToOne
    @JoinColumn(name = "id_tipo_peso")
    private TipoPeso idTipoPeso;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca idMarca;

    @ManyToOne
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto idCategoriaProducto;

    @Override
    public String toString() {
        return "Producto{" +
                "productoId=" + productoId +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", peso=" + peso +
                ", imagen='" + imagen + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", idTipoPeso=" + idTipoPeso +
                ", idmarca=" + idMarca +
                ", idCategoriaProducto=" + idCategoriaProducto +
                '}';
    }
}
