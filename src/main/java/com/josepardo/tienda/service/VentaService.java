package com.josepardo.tienda.service;

import com.josepardo.tienda.entity.Proveedor;
import com.josepardo.tienda.entity.Venta;
import com.josepardo.tienda.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VentaService {

    VentaRepository ventaRepository;

    public void saveVenta(Venta venta){

        ventaRepository.save(venta);
    }

    public List<Venta> verVenta(){

        return ventaRepository.findAll();
    }

    public Venta verVentaPorId(Integer idVenta) {

        return ventaRepository.findById(idVenta).get();
    }

    public void eliminarVennta(Integer idVenta){

        ventaRepository.deleteById(idVenta);
    }
}
