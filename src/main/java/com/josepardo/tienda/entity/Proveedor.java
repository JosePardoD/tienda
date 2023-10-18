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
@Table(name="proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;
    private String nombreProveedor;
    private String correo;
    private String direccion;
    private int telefono;
    private Date fechaVenta;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"proveedor"})
    @JoinTable(
            name = "productos_proveedor",
            joinColumns = @JoinColumn(name = "id_proveedor",referencedColumnName = "idProveedor"),
            inverseJoinColumns = @JoinColumn(name = "id_productos",referencedColumnName = "idProducto"))
    private List<Producto> productos;

}
