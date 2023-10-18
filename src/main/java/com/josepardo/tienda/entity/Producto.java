package com.josepardo.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombreProducto;
    private Double precio;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categorias")
    @JsonIgnoreProperties({"producto"})
    private Categorias categorias;

    @ManyToMany(mappedBy = "productos")
    @JsonIgnoreProperties({"producto","categorias"})
    private List<Proveedor> proveedores;

    @ManyToMany(mappedBy = "productos")
    @JsonIgnoreProperties({"producto","categorias","proveedores"})
    private List<Venta> vemtas;

}

