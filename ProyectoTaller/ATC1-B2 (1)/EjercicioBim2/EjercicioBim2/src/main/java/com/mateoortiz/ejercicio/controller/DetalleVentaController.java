package com.mateoortiz.ejercicio.controller;

import com.mateoortiz.ejercicio.entity.DetalleVenta;
import com.mateoortiz.ejercicio.service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detalle-venta")
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaService.getAllDetalleVenta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetalleVentaById(@PathVariable @Valid Integer id) {
        DetalleVenta detalle = detalleVentaService.getDetalleVentaById(id);
        if (detalle != null) {
            return ResponseEntity.ok(detalle);
        } else {
            return ResponseEntity.status(404).body("No existe el detalle de venta");
        }
    }

    @PostMapping
    public ResponseEntity<?> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta creado = detalleVentaService.saveDetalleVenta(detalleVenta);
            return ResponseEntity.ok().body(creado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetalleVenta(@PathVariable Integer id, @Valid @RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta actualizado = detalleVentaService.updateDetalleVenta(id, detalleVenta);
            if (actualizado != null) {
                return ResponseEntity.ok(actualizado);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetalleVenta(@PathVariable @Valid Integer id) {
        DetalleVenta detalle = detalleVentaService.getDetalleVentaById(id);
        if (detalle != null) {
            detalleVentaService.deleteDetalleVenta(id);
            return ResponseEntity.ok().body("Se eliminó el detalle de venta");
        } else {
            return ResponseEntity.status(404).body("No existe el detalle de venta");
        }
    }
}