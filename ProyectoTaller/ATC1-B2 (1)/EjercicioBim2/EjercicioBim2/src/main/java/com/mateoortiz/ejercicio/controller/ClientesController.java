package com.mateoortiz.ejercicio.controller;

import com.mateoortiz.ejercicio.entity.Clientes;
import com.mateoortiz.ejercicio.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> getAllClientes() {
        return clientesService.getAllClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable @Valid Integer id) {
        Clientes cliente = clientesService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.status(404).body("No existe el cliente");
        }
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@Valid @RequestBody Clientes cliente) {
        try {
            Clientes creado = clientesService.saveCliente(cliente);
            return ResponseEntity.ok().body(creado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Integer id, @Valid @RequestBody Clientes cliente) {
        try {
            Clientes actualizado = clientesService.updateCliente(id, cliente);
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
    public ResponseEntity<?> deleteCliente(@PathVariable @Valid Integer id) {
        Clientes cliente = clientesService.getClienteById(id);
        if (cliente != null) {
            clientesService.deleteCliente(id);
            return ResponseEntity.ok().body("Se eliminó el cliente");
        } else {
            return ResponseEntity.status(404).body("No existe el cliente");
        }
    }
}
