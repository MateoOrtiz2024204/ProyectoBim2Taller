package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> getAllDetalleVenta();
    DetalleVenta getDetalleVentaById(Integer id);
    DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta);
    DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta);
    void deleteDetalleVenta(Integer id);
}
