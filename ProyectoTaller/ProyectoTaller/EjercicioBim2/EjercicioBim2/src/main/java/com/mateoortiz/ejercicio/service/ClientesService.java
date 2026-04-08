package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Clientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientesService {
    List<Clientes> getAllClientes();
    Clientes getClienteById(Integer id);
    Clientes saveCliente(Clientes cliente);
    Clientes updateCliente(Integer id, Clientes cliente);
    void deleteCliente(Integer id);
}
