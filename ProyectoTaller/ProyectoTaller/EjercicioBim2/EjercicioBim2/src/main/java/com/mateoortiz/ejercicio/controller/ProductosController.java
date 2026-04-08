package com.mateoortiz.ejercicio.controller;

import com.mateoortiz.ejercicio.entity.Productos;
import com.mateoortiz.ejercicio.service.ProductosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public List<Productos> getAllProductos() {
        return productosService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable @Valid Integer id) {
        Productos producto = productosService.getProductoById(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.status(404).body("No existe el producto");
        }
    }

    @PostMapping
    public ResponseEntity<?> createProducto(@Valid @RequestBody Productos producto) {
        try {
            Productos creado = productosService.saveProducto(producto);
            return ResponseEntity.ok().body(creado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Integer id, @Valid @RequestBody Productos producto) {
        try {
            Productos actualizado = productosService.updateProducto(id, producto);
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
    public ResponseEntity<?> deleteProducto(@PathVariable @Valid Integer id) {
        Productos producto = productosService.getProductoById(id);
        if (producto != null) {
            productosService.deleteProducto(id);
            return ResponseEntity.ok().body("Se eliminó el producto");
        } else {
            return ResponseEntity.status(404).body("No existe el producto");
        }
    }
}
