package com.josepardo.tienda.service;

import com.josepardo.tienda.entity.Producto;
import com.josepardo.tienda.entity.Proveedor;
import com.josepardo.tienda.repository.ProductoRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProductoService {

    private ProductoRepository productoRepository;


    public void saveProducto(Producto producto){

        productoRepository.save(producto);
    }

    public List<Producto> verProducto(){

        return productoRepository.findAll();
    }
    public Optional<Producto> getProducto(Integer idProducto){

        return productoRepository.findById(idProducto);
    }

    public Producto verProductoPorId(Integer idProducto) {

        return productoRepository.findById(idProducto).get();
    }

    public void eliminarProducto(Integer idProducto){

        productoRepository.deleteById(idProducto);
    }



}
