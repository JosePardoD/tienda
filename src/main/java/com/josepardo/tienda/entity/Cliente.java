package com.josepardo.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    private String nombreCliente;
    private String correo;
    private String telefono;
    private Integer direccion;

    // client to reservation
    @OneToMany(mappedBy = "cliente")
    @JsonIgnoreProperties({"cliente"})
    private List<Venta> ventas;

}
