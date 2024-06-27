package com.tienda.almacen.controller;

import com.tienda.almacen.entities.Producto;
import com.tienda.almacen.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoController {

    private ProductoService productoService;

    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoService.saveProducto(producto);
        return "Producto creado con exito";
    }

    @GetMapping("/obtener/{id}")
    public Producto obtenerProducto(@PathVariable Long id){
        return productoService.findProducto(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Producto> obtenerTodo(){
        return productoService.findProductos();
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return "Producto eliminado con exito";
    }

    @PutMapping("/editar/{id}")
    public Producto editarProducto(@PathVariable Long id,
                                   @RequestBody Producto producto){
        return productoService.editProducto(id, producto);
    }
}
