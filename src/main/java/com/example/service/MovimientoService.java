package com.example.service;

import com.example.domain.Movimiento;
import com.example.domain.Producto;

import java.util.List;

public interface MovimientoService {
    List<Movimiento> obtenerTodos();

    Movimiento guardarMovimiento(Producto producto, int cantidad);

    Movimiento obtenerPorId(Long id);

    boolean eliminarMovimiento(Long id);
}