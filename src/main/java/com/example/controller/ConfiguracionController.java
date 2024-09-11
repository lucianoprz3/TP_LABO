package com.example.controller;

import com.example.domain.Configuracion;
import com.example.service.ConfiguracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://gestionstock-tplabo.netlify.app")
@RestController
@RequestMapping("config")
public class ConfiguracionController {
    @Autowired
    ConfiguracionService configuracionService;

    @PutMapping("/{id}")
    public ResponseEntity<Configuracion> guardarConfiguracion(@PathVariable Long id, @RequestBody Configuracion configuracion) {
        Configuracion configActual = configuracionService.encontrarConfiguracionPorId(id);
        if(configActual == null)
            return ResponseEntity.notFound().build();
        configActual.setStockMin(configuracion.getStockMin());
        configActual.setPorcentajeCostoMax(configuracion.getPorcentajeCostoMax());
        return ResponseEntity.ok(configuracionService.guardar(configActual));
    }
}
