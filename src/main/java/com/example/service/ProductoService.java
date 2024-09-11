package com.example.service;

import com.example.domain.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();

    Producto guardar(Producto producto);

    void eliminar(Producto producto);

    Producto encontrarProducto(Producto producto);

    Producto encontrarProductoPorId(Long id);

}

