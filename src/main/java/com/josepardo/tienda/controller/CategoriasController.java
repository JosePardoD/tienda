package com.josepardo.tienda.controller;

import com.josepardo.tienda.entity.Categorias;
import com.josepardo.tienda.service.CategoriasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

@AllArgsConstructor
public class CategoriasController {

    private CategoriasService categoriasService;
    @GetMapping("/categorias")
    private String verCategorias(Model model){
        model.addAttribute("categoriass", categoriasService.verCategorias());
        return "categorias";
    }

    @GetMapping("/agregarcategoria")
    private String   formularioCategorias(Categorias categorias){
        return "agregarcategoria";
    }

    @PostMapping("/categorias")
    public String saveCategorias(Categorias categorias){
       categoriasService.saveCategorias(categorias);
        return "redirect:/categorias";
   }

    @GetMapping("/categorias/editar/{id_Categoria}")
    private String verCategoriaPorId(@PathVariable("id_Categoria") Integer id_Categoria, Model model){
        Categorias categorias = categoriasService.verCategoriaPorId(id_Categoria);
        model.addAttribute("categoria", categorias);
        return "actualizarcategoria";
    }

    @PostMapping("/categorias/actualizar/{id_Categoria}")
    private String editarCategoria(@PathVariable("id_Categoria") Integer id_Categoria,Categorias categorias){
        categoriasService.saveCategorias(categorias);
        return "redirect:/categorias";
    }

    @GetMapping("categorias/borrar/{id_Categoria}")
    private String eliminarCategoria(@PathVariable("id_Categoria") Integer id_Categoria){
        categoriasService.eliminarCategoria(id_Categoria);
        return "redirect:/categorias";
    }


}
