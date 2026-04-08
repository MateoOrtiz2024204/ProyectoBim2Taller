package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas getVentaById(Integer id);
    Ventas saveVenta(Ventas venta);
    Ventas updateVenta(Integer id, Ventas venta);
    void deleteVenta(Integer id);
}
