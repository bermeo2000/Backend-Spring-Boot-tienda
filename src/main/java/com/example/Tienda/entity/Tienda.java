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
@Table(name = "tiendas")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tienda")
    private Long tiendaId;

    @NotNull
    @Column(name = "nombre_tienda")
    private String nombreTienda;

    @NotNull
    @Column(name = "ciudad")
    private String ciudad;

    @NotNull
    @Column(name = "direccion")
    private String direccion;

    @NotNull
    @Column(name = "celular")
    private String celular;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria_tienda")
    private CategoriaTienda idCategoriaTienda;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Override
    public String toString() {
        return "Tienda{" +
                "tiendaId=" + tiendaId +
                ", nombreTienda='" + nombreTienda + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", celular='" + celular + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", idCategoriaTienda=" + idCategoriaTienda +
                ", usuario=" + usuario +
                '}';
    }
}
