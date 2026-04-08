package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Integer id);
    Usuarios saveUsuario(Usuarios usuario);
    Usuarios updateUsuario(Integer id, Usuarios usuario);
    void deleteUsuario(Integer id);
}
