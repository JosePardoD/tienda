package com.josepardo.tienda.service;

import com.josepardo.tienda.entity.Producto;
import com.josepardo.tienda.entity.ProductosVenta;
import com.josepardo.tienda.repository.ProductoVentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoVentaService {


    private ProductoVentaRepository productoVentaRepository;

    public void saveProductoVenta(ProductosVenta productosVenta){

        productoVentaRepository.save(productosVenta);
    }

    public List<ProductosVenta> verProductoVenta(){

        return productoVentaRepository.findAll();
    }


    public Optional<ProductosVenta> getProductoVenta(Integer id){

        return productoVentaRepository.findById(id);
    }


    public ProductosVenta verProductoVentaporID(Integer iProductoVenta) {

        return productoVentaRepository.findById(iProductoVenta).get();
    }

    public void eliminarProductoVenta(Integer iProductoVenta){

        productoVentaRepository.deleteById(iProductoVenta);
    }


}
