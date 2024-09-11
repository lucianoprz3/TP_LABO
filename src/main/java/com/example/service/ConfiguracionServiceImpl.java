package com.example.service;

import com.example.dao.ConfiguracionDao;
import com.example.domain.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracionServiceImpl implements ConfiguracionService {
    @Autowired
    ConfiguracionDao configuracionDao;

    @Override
    public Configuracion guardar(Configuracion configuracion) {
        return configuracionDao.save(configuracion);
    }

    @Override
    public Configuracion encontrarConfiguracionPorId(Long id) {
        return configuracionDao.findById(id).orElse(null);
    }

    @Override
    public Configuracion darPrimeraConfiguracion() {
        return configuracionDao.findById((long)1).orElse(null);
    }

}
