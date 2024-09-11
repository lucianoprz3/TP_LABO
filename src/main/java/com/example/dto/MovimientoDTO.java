package com.example.dto;

import com.example.domain.Movimiento;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimientoDTO {
    private Long id;

    private String tipo;

    private String tipoProducto;

    private int cantidad;

    private LocalDateTime fechaHora;

    private double costoTotal;

    public MovimientoDTO(Movimiento movimiento) {
        id = movimiento.getId();
        tipo = movimiento.getTipo();
        tipoProducto = movimiento.getProducto().getTipo() + " " + movimiento.getProducto().getMarca();
        cantidad = movimiento.getCantidad();
        fechaHora = movimiento.getFechaHora();
        costoTotal = movimiento.getCostoTotal();
    }
}