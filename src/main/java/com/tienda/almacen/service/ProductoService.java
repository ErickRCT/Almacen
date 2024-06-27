package com.tienda.almacen.service;

import com.tienda.almacen.entities.Producto;

import java.util.List;

public interface ProductoService {

    void saveProducto(Producto producto);

    Producto findProducto(Long id);

    List<Producto> findProductos();

    void deleteProducto(Long id);

    Producto editProducto(Long id, Producto producto);

}
