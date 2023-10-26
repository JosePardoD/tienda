package com.josepardo.tienda.service;

import com.josepardo.tienda.entity.Categorias;
import com.josepardo.tienda.repository.CategoriasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriasService {

    private  CategoriasRepository categoriasRepository;

    public void saveCategorias(Categorias categorias){

        categoriasRepository.save(categorias);
    }

    public List<Categorias> verCategorias(){

        return categoriasRepository.findAll();
    }



    public Categorias verCategoriaPorId(Integer id_Categoria) {
        return categoriasRepository.findById(id_Categoria).get();
    }

    public void eliminarCategoria(Integer id_Categoria){

        categoriasRepository.deleteById(id_Categoria);
    }



}

