package com.mateoortiz.ejercicio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigoVenta;

    @NotNull(message = "El DPI del cliente es obligatorio")
    @Column(name = "dpi_cliente")
    private Integer dpiCliente;

    @NotNull(message = "El código de usuario es obligatorio")
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotNull(message = "La fecha de venta es obligatoria")
    @Column(name = "fecha_venta")
    private LocalDate fechaVenta;

    @NotNull(message = "El total es obligatorio")
    @Positive(message = "El total debe ser un número positivo")
    @Column(name = "total")
    private BigDecimal total;

    @NotNull(message = "El estado es obligatorio")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Integer getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(Integer dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
