package com.example.service;

import com.example.dao.MovimientoDao;
import com.example.domain.Movimiento;
import com.example.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoDao movimientoDao;

    @Override
    public List<Movimiento> obtenerTodos() {
        return (List<Movimiento>) movimientoDao.findAll();
    }

    @Override
    public Movimiento guardarMovimiento(Producto producto, int cantidad) {
        Movimiento movimiento = new Movimiento();

        if(cantidad < 0)
            movimiento.setTipo("Salida");
        else {
            movimiento.setTipo("Ingreso");
            movimiento.setCostoTotal(producto.getCosto() * cantidad);
        }

        movimiento.setProducto(producto);
        movimiento.setFechaHora(LocalDateTime.now());
        movimiento.setCantidad(cantidad);

        return movimientoDao.save(movimiento);
    }

    @Override
    public Movimiento obtenerPorId(Long id) {
        Optional<Movimiento> movimiento = movimientoDao.findById(id);
        return movimiento.orElse(null);
    }

    @Override
    public boolean eliminarMovimiento(Long id) {
        if (movimientoDao.existsById(id)) {
            movimientoDao.deleteById(id);
            return true;
        }
        return false;
    }
}
