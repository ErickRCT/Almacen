package com.tienda.almacen.controller;

import com.tienda.almacen.entities.Cliente;
import com.tienda.almacen.entities.Producto;
import com.tienda.almacen.service.ClienteService;
import com.tienda.almacen.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return "Cliente creado con exito";
    }

    @GetMapping("/obtener/{id}")
    public Cliente obtenerCliente(@PathVariable Long id){
        return clienteService.findCliente(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Cliente> obtenerTodo(){
        return clienteService.findClientes();
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id){
        clienteService.deleteCliente(id);
        return "Producto eliminado con exito";
    }

    @PutMapping("/editar/{id}")
    public Cliente editarCliente(@PathVariable Long id,
                                   @RequestBody Cliente cliente){
        return clienteService.editCliente(id, cliente);
    }
}
