package com.mateoortiz.ejercicio.controller;

import com.mateoortiz.ejercicio.entity.Ventas;
import com.mateoortiz.ejercicio.service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllVentas() {
        return ventasService.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVentaById(@PathVariable @Valid Integer id) {
        Ventas venta = ventasService.getVentaById(id);
        if (venta != null) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.status(404).body("No existe la venta");
        }
    }

    @PostMapping
    public ResponseEntity<?> createVenta(@Valid @RequestBody Ventas venta) {
        try {
            Ventas creada = ventasService.saveVenta(venta);
            return ResponseEntity.ok().body(creada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenta(@PathVariable Integer id, @Valid @RequestBody Ventas venta) {
        try {
            Ventas actualizada = ventasService.updateVenta(id, venta);
            if (actualizada != null) {
                return ResponseEntity.ok(actualizada);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable @Valid Integer id) {
        Ventas venta = ventasService.getVentaById(id);
        if (venta != null) {
            ventasService.deleteVenta(id);
            return ResponseEntity.ok().body("Se eliminó la venta");
        } else {
            return ResponseEntity.status(404).body("No existe la venta");
        }
    }
}
