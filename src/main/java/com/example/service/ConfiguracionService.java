package com.example.service;

import com.example.domain.Configuracion;

public interface ConfiguracionService {
    Configuracion guardar(Configuracion configuracion);
    Configuracion encontrarConfiguracionPorId(Long id);
    Configuracion darPrimeraConfiguracion();
}
