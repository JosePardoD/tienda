package com.josepardo.tienda.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaVenta;

    @ManyToOne
    @JoinColumn(name = "cliente")
    @JsonIgnoreProperties({"venta"})
    private Cliente cliente;

    @OneToMany(mappedBy = "venta")
    @JsonIgnoreProperties({"venta"})
    private List<ProductosVenta> productosVentas;


}
