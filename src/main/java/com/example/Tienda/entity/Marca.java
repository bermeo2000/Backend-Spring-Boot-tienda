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
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long marcaId;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Lob
    @NotNull
    @Column(name = "imagen")
    private String imagen;

    @NotNull
    @Column(name = "estado")
    private Boolean estado = true;


    @Override
    public String toString() {
        return "Marca{" +
                "marcaId=" + marcaId +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                '}';
    }
}
