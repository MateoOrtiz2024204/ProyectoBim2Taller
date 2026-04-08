package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Ventas;
import com.mateoortiz.ejercicio.repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService {

    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllVentas() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas getVentaById(Integer id) {
        return ventasRepository.findById(id).orElse(null);
    }

    @Override
    public Ventas saveVenta(Ventas venta) {
        return ventasRepository.save(venta);
    }

    @Override
    public Ventas updateVenta(Integer id, Ventas venta) {
        Ventas existente = ventasRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setDpiCliente(venta.getDpiCliente());
        existente.setCodigoUsuario(venta.getCodigoUsuario());
        existente.setFechaVenta(venta.getFechaVenta());
        existente.setTotal(venta.getTotal());
        existente.setEstado(venta.getEstado());
        return ventasRepository.save(existente);
    }

    @Override
    public void deleteVenta(Integer id) {
        ventasRepository.deleteById(id);
    }
}
