package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Productos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductosService {
    List<Productos> getAllProductos();
    Productos getProductoById(Integer id);
    Productos saveProducto(Productos producto);
    Productos updateProducto(Integer id, Productos producto);
    void deleteProducto(Integer id);
}
