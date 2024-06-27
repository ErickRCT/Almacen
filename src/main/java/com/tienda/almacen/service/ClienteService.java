package com.tienda.almacen.service;

import com.tienda.almacen.entities.Cliente;
import com.tienda.almacen.entities.Producto;

import java.util.List;

public interface ClienteService {
    void saveCliente(Cliente cliente);

    Cliente findCliente(Long id);

    List<Cliente> findClientes();

    void deleteCliente(Long id);

    Cliente editCliente(Long id, Cliente cliente);
}
