package com.example.Tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria_tienda")
public class CategoriaTienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_tienda")
    private Long tiendaCategoriaId;

    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "estado")
    private Boolean estado = true;

    @OneToMany(mappedBy = "idCategoriaTienda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Tienda> tiendas = new ArrayList<>();

    @Override
    public String toString() {
        return "CategoriaTienda{" +
                "tiendaCategoriaId=" + tiendaCategoriaId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", tiendas=" + tiendas +
                '}';
    }
}
