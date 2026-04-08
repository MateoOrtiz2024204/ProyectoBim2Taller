package com.mateoortiz.ejercicio.repository;

import com.mateoortiz.ejercicio.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}
