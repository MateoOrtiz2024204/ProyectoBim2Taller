package com.mateoortiz.ejercicio.service;

import com.mateoortiz.ejercicio.entity.Productos;
import com.mateoortiz.ejercicio.repository.ProductosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductosServiceImplements implements ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosServiceImplements(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductoById(Integer id) {
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    public Productos saveProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    public Productos updateProducto(Integer id, Productos producto) {
        Productos existente = productosRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setNombreProducto(producto.getNombreProducto());
        existente.setPrecio(producto.getPrecio());
        existente.setStock(producto.getStock());
        existente.setEstado(producto.getEstado());
        return productosRepository.save(existente);
    }

    @Override
    public void deleteProducto(Integer id) {
        productosRepository.deleteById(id);
    }
}
