package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.DetalleVenta;
import com.mateoortiz.ejercicio.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {

    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta existente = detalleVentaRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setCodigoProducto(detalleVenta.getCodigoProducto());
        existente.setCodigoVenta(detalleVenta.getCodigoVenta());
        existente.setCantidad(detalleVenta.getCantidad());
        existente.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        existente.setSubtotal(detalleVenta.getSubtotal());
        return detalleVentaRepository.save(existente);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}
