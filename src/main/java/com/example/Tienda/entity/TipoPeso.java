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
@Table(name = "tipo_pesos")
public class TipoPeso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_peso")
    private Long pesoTipoId;

    @NotNull
    @Column(name = "tipo")
    private String tipo;

    @NotNull
    @Column(name = "estado")
    private Boolean estado = true;

    @Override
    public String toString() {
        return "TipoPeso{" +
                "pesoTipoId=" + pesoTipoId +
                ", tipo='" + tipo + '\'' +
                ", estado=" + estado +
                '}';
    }
}
