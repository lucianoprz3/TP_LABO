package com.example.dto;

import com.example.domain.Producto;
import lombok.Data;

@Data
public class CompraDTO {
    private String tipoProducto;
    private String marca;
    private int cantidad;

    public CompraDTO(Producto producto, int cantidad) {
        tipoProducto = producto.getTipo();
        marca = producto.getMarca();
        this.cantidad = cantidad;
    }
}