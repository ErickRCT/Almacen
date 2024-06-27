package com.tienda.almacen.service;

import com.tienda.almacen.entities.Producto;
import com.tienda.almacen.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private ProductoRepository productoRepository;

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findProductos() {
        return productoRepository.findAll();
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto editProducto(Long id, Producto producto) {
        Producto productoOriginal = this.findProducto(id);
        if (productoOriginal != null){
            productoOriginal.setNombre(producto.getNombre());
            productoOriginal.setMarca(producto.getMarca());
            productoOriginal.setPrecio(producto.getPrecio());
            productoOriginal.setStock(producto.getStock());
            this.saveProducto(productoOriginal);
            return this.findProducto(id);
        } else {
            return null;
        }
    }
}
