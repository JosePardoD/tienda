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
@ToString
@Table(name="categorias")
public class Categorias {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Categoria;
    private String tipocategoria;
    private String descripcion;

    @OneToMany(mappedBy = "categorias")
    @JsonIgnoreProperties({"categorias"})
    private List<Producto> Productos;
}
