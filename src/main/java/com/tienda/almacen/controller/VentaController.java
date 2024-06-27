package com.tienda.almacen.controller;

import com.tienda.almacen.entities.Venta;
import com.tienda.almacen.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
@AllArgsConstructor
public class VentaController {

    private VentaService ventaService;

    @PostMapping("/crear/{idCliente}")
    public Venta crearVenta(@PathVariable Long idCliente ,
                            @RequestBody List<Long> idProductos){
        return ventaService.saveVenta(idCliente, idProductos);
    }

    @GetMapping("/obtenerTodo")
    public List<Venta> obtenerTodo(){
        return ventaService.findVentas();
    }
}
