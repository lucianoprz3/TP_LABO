package com.example.dao;

import com.example.domain.Movimiento;
import org.springframework.data.repository.CrudRepository;

public interface MovimientoDao extends CrudRepository<Movimiento, Long> {
}
