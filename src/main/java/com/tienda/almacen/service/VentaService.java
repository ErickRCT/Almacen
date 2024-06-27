package com.tienda.almacen.service;

import com.tienda.almacen.entities.Cliente;
import com.tienda.almacen.entities.Producto;
import com.tienda.almacen.entities.Venta;

import java.util.List;

public interface VentaService {

    Venta saveVenta(Long idCliente , List<Long> idProductos);

    Venta findVenta(Long id);

    List<Venta> findVentas();

    void deleteVenta(Long id);

    Venta editVenta(Long id, Venta venta);

}
