package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Usuarios;
import com.mateoortiz.ejercicio.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosServiceImplements(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public List<Usuarios> getAllUsuarios() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUsuarioById(Integer id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios saveUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios updateUsuario(Integer id, Usuarios usuario) {
        Usuarios existente = usuariosRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setUsername(usuario.getUsername());
        existente.setPassword(usuario.getPassword());
        existente.setEmail(usuario.getEmail());
        existente.setRol(usuario.getRol());
        existente.setEstado(usuario.getEstado());
        return usuariosRepository.save(existente);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuariosRepository.deleteById(id);
    }
}
