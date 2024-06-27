package com.tienda.almacen.service;

import com.tienda.almacen.entities.Cliente;
import com.tienda.almacen.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private ClienteRepository clienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> findClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente editCliente(Long id, Cliente cliente) {
        Cliente clienteOriginal = this.findCliente(id);
        if (clienteOriginal != null){
            clienteOriginal.setNombre(cliente.getNombre());
            clienteOriginal.setApellido(cliente.getApellido());
            clienteOriginal.setRut(cliente.getRut());
            clienteOriginal.getListaVentas().addAll(cliente.getListaVentas());
            this.saveCliente(clienteOriginal);
            return this.findCliente(id);
        } else {
            return null;
        }
    }
}
