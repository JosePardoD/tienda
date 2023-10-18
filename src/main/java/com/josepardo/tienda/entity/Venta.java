package com.josepardo.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;
    private String valorVenta;
    private Date fechaVenta;

    @ManyToOne
    @JoinColumn(name = "cliente")
    @JsonIgnoreProperties({"venta"})
    private Cliente cliente;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"proveedor"})
    @JoinTable(
            name = "productos_ventas",
            joinColumns = @JoinColumn(name = "id_venta",referencedColumnName = "idventa"),
            inverseJoinColumns = @JoinColumn(name = "id_productos",referencedColumnName = "idProducto"))
    private List<Producto> productos;


}
