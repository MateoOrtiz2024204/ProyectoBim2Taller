package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Clientes;
import com.mateoortiz.ejercicio.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {

    private final ClientesRepository clientesRepository;

    public ClientesServiceImplements(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes getClienteById(Integer id) {
        return clientesRepository.findById(id).orElse(null);
    }

    @Override
    public Clientes saveCliente(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    @Override
    public Clientes updateCliente(Integer id, Clientes cliente) {
        Clientes existente = clientesRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setNombreCliente(cliente.getNombreCliente());
        existente.setApellidoCliente(cliente.getApellidoCliente());
        existente.setDireccion(cliente.getDireccion());
        existente.setEstado(cliente.getEstado());
        return clientesRepository.save(existente);
    }

    @Override
    public void deleteCliente(Integer id) {
        clientesRepository.deleteById(id);
    }
}
