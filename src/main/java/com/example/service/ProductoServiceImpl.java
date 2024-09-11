package com.example.service;

import com.example.dao.ProductoDao;
import com.example.domain.Configuracion;
import com.example.domain.Producto;
import com.example.dto.CompraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Autowired
    private ApiCompraService apiCompraService;

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private ConfiguracionService configuracionService;

    @Override
    public List<Producto> listarProductos() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        if(producto.getId() == null){
            Producto p = productoDao.save(producto);
            registrarMovimiento(p, producto.getStock());
            return p;
        }
        compraAutomatica(producto);
        return productoDao.save(producto);
    }

    @Override
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    public Producto encontrarProducto(Producto producto) {
        return productoDao.findById(producto.getId()).orElse(null);
    }

    @Override
    public Producto encontrarProductoPorId(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    //Compra automática

    private void compraAutomatica(Producto producto) {
        Configuracion config = configuracionService.darPrimeraConfiguracion();
        if(producto.getStock() <= config.getStockMin()) {
            double costo = apiCompraService.pedirCosto(producto).getCosto();
            if(costo <= producto.getCosto() * (1 + config.getPorcentajeCostoMax())){
                int cantidad = config.getStockMin() - producto.getStock();
                if(apiCompraService.comprar(new CompraDTO(producto, cantidad)).getMessage().equals("Compra realizada con exito")) {
                    registrarMovimiento(producto, cantidad);
                    producto.setStock(producto.getStock() + cantidad);
                    productoDao.save(producto);
                }
            }
        }
    }

    private void registrarMovimiento(Producto producto, int cantidad){
        movimientoService.guardarMovimiento(producto, cantidad);
    }
}
