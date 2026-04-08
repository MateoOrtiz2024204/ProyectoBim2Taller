package com.mateoortiz.ejercicio.repository;

import com.mateoortiz.ejercicio.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}
