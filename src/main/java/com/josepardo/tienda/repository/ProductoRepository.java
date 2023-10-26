package com.josepardo.tienda.repository;


import com.josepardo.tienda.entity.Producto;
import com.josepardo.tienda.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
