package com.tienda.almacen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long IdCliente;
    private String nombre;
    private String apellido;
    private String rut;
    @OneToMany
    @JsonIgnore
    private List<Venta> listaVentas;

}
