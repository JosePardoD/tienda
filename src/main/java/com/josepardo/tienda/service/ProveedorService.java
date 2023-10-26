package com.josepardo.tienda.service;

import com.josepardo.tienda.entity.Proveedor;
import com.josepardo.tienda.repository.ProductoVentaRepository;
import com.josepardo.tienda.repository.ProovedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProveedorService {

    private ProovedorRepository proovedorRepository;


    public void saveProveedor(Proveedor proveedor){

        proovedorRepository.save(proveedor);
    }

    public List<Proveedor> verProveedor(){

        return proovedorRepository.findAll();
    }

    public Proveedor verProveedorPorId(Integer idProveedor) {

        return proovedorRepository.findById(idProveedor).get();
    }

    public void eliminarProveedor(Integer idProveedor){

        proovedorRepository.deleteById(idProveedor);
    }


}
