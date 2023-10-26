package com.josepardo.tienda.repository;

import com.josepardo.tienda.entity.ProductosVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoVentaRepository extends JpaRepository <ProductosVenta,Integer> {
}
