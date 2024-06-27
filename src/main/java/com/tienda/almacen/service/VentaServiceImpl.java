package com.tienda.almacen.service;

import com.tienda.almacen.entities.Cliente;
import com.tienda.almacen.entities.Producto;
import com.tienda.almacen.entities.Venta;
import com.tienda.almacen.repository.ClienteRepository;
import com.tienda.almacen.repository.ProductoRepository;
import com.tienda.almacen.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class VentaServiceImpl implements VentaService{

    private VentaRepository ventaRepository;
    private ClienteRepository clienteRepository;
    private ProductoRepository productoRepository;

    @Override
    public Venta saveVenta(Long idCliente , List<Long> idProductos) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        // Obtener los productos por sus IDs
        List<Producto> productos = productoRepository.findAllById(idProductos);
        // Verificar que la lista de productos no esté vacía y que todos los IDs sean válidos
        if (productos.isEmpty() || productos.size() != idProductos.size()) {
            throw new RuntimeException("No se encontraron productos con los IDs proporcionados");
        }
        // Crear y guardar la venta
        Venta venta = new Venta();
        venta.setCliente(cliente);
        venta.setListaProductos(productos);
        venta.setFecha(LocalDate.now());
        venta.setTotal(productos.stream().mapToDouble(Producto::getPrecio).sum());
        cliente.getListaVentas().add(venta);
        ventaRepository.save(venta);
        clienteRepository.save(cliente);
        return this.findVenta(venta.getIdVenta());
    }

    @Override
    public Venta findVenta(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Venta> findVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta editVenta(Long id, Venta venta) {
        Venta ventaOriginal = this.findVenta(id);
        if (ventaOriginal != null){
            ventaOriginal.setFecha(venta.getFecha());
            ventaOriginal.setTotal(venta.getTotal());
            ventaOriginal.getListaProductos().addAll(venta.getListaProductos());
            ventaOriginal.setCliente(venta.getCliente());
            ventaRepository.save(ventaOriginal);
            return this.findVenta(id);
        } else {
            return null;
        }
    }
}
