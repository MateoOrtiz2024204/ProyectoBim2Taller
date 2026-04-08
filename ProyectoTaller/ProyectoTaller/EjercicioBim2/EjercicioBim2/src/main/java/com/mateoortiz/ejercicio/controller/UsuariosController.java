package com.mateoortiz.ejercicio.controller;

import com.mateoortiz.ejercicio.entity.Usuarios;
import com.mateoortiz.ejercicio.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarios() {
        return usuariosService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable @Valid Integer id) {
        Usuarios usuario = usuariosService.getUsuarioById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(404).body("No existe el usuario");
        }
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@Valid @RequestBody Usuarios usuario) {
        try {
            Usuarios creado = usuariosService.saveUsuario(usuario);
            return ResponseEntity.ok().body(creado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer id, @Valid @RequestBody Usuarios usuario) {
        try {
            Usuarios actualizado = usuariosService.updateUsuario(id, usuario);
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
    public ResponseEntity<?> deleteUsuario(@PathVariable @Valid Integer id) {
        Usuarios usuario = usuariosService.getUsuarioById(id);
        if (usuario != null) {
            usuariosService.deleteUsuario(id);
            return ResponseEntity.ok().body("Se eliminó el usuario");
        } else {
            return ResponseEntity.status(404).body("No existe el usuario");
        }
    }
}
