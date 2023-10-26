package com.josepardo.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="productosventa")
public class ProductosVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iProductoVenta;
    private String nombre;
    private double cantidad;
    private double precio;
    private double total;

    @ManyToOne
    @JoinColumn(name = "venta")
    @JsonIgnoreProperties({"productosventa","venta","producto"})
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "producto")
    @JsonIgnoreProperties({"productosventa","venta","producto"})
    private Producto producto;





}
