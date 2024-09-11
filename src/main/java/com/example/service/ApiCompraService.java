package com.example.service;

import com.example.dto.CompraDTO;
import com.example.domain.Producto;
import com.example.dto.CompraResponseDTO;
import com.example.dto.CostoDTO;

public interface ApiCompraService {
    CostoDTO pedirCosto(Producto producto);
    CompraResponseDTO comprar(CompraDTO compra);
}
