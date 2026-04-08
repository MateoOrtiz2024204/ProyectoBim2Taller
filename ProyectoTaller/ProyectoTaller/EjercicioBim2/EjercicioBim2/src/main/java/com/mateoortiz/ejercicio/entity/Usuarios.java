package com.mateoortiz.ejercicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotBlank(message = "El username es obligatorio")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "El password es obligatorio")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "El email es obligatorio")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "El rol es obligatorio")
    @Column(name = "rol")
    private String rol;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
