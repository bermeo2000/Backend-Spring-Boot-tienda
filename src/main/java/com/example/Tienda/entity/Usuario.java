package com.example.Tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_usuario")
    private Long usuarioId;

    @NotNull
    @Column (name = "nombreUsuario")
    private String nombreUsuario;

    @NotNull
    @Column (name = "nombre")
    private String nombre;

    @NotNull
    @Column (name = "apellido")
    private String apellido;


    @NotNull
    @Column (name = "email")
    private String email;

    @NotNull
    @Column (name = "password")
    private String password;

    @NotNull
    @Column (name = "cedula")
    private String cedula;

    @NotNull
    @Column (name = "telefono")
    private String telefono;

    @NotNull
    @Column (name = "imagen")
    private String imagen;

    @NotNull
    @Column (name = "estado")
    private Boolean estado = true;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();


    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Tienda> tiendas = new ArrayList<>();

    @Override
    public String toString() {
        return "Usuario{" +
                "usuarioId=" + usuarioId +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cedula='" + cedula + '\'' +
                ", telefono='" + telefono + '\'' +
                ", imagen='" + imagen + '\'' +
                ", estado=" + estado +
                ", tiendas=" + tiendas +
                '}';
    }
}
