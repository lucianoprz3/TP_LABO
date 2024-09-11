package com.example.service;

import com.example.dto.CompraDTO;
import com.example.domain.Producto;
import com.example.dto.CompraResponseDTO;
import com.example.dto.CostoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiCompraServiceImpl implements ApiCompraService{
    @Value("${base-url}")
    protected String baseUrl;
    @Autowired
    private RestTemplate restTemplate;


    @Override
    public CostoDTO pedirCosto(Producto producto) {
        return restTemplate.getForObject(baseUrl + "costo" + "?tipoProducto=" + producto.getTipo() + "&marca=" + producto.getMarca(), CostoDTO.class);
    }

    @Override
    public CompraResponseDTO comprar(CompraDTO compra) {
        return restTemplate.postForObject(baseUrl + "compra", compra, CompraResponseDTO.class);
    }
}
