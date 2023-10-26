package com.josepardo.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombreProducto;
    private Double precio;
    private Double cantidad;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "categorias")
    @JsonIgnoreProperties({"producto","categorias","proveedor"})
    private Categorias categorias;

    @ManyToOne
    @JoinColumn(name = "proveedor")
    @JsonIgnoreProperties({"producto","categorias","proveedor"})
    private Proveedor proveedor;


}

