package com.josepardo.tienda.controller;

import com.josepardo.tienda.entity.Categorias;
import com.josepardo.tienda.entity.Producto;

import com.josepardo.tienda.entity.Proveedor;
import com.josepardo.tienda.service.CategoriasService;
import com.josepardo.tienda.service.ProductoService;

import com.josepardo.tienda.service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@AllArgsConstructor
public class PruductoController {


    private ProductoService productoService;
    private CategoriasService categoriasService;
    private ProveedorService proveedorService;
    @GetMapping("/producto")
    private String verProductoo(Model model){

        model.addAttribute("productos", productoService.verProducto());
        model.addAttribute("categoriass", categoriasService.verCategorias());

        return "producto";
    }
    @GetMapping("/agregarproducto")
    private String formularioProducto(Model model,Producto producto){
        List<Categorias> listCategorias=categoriasService.verCategorias();
        model.addAttribute("categoriass", listCategorias);

        List<Proveedor> listProveedores=proveedorService.verProveedor();
        model.addAttribute("proveedores", listProveedores);
        return "agregarproducto";
    }

    @PostMapping("/producto")
    public String saveProducto(Producto producto){

        productoService.saveProducto(producto);
        return "redirect:/producto";
    }

    @GetMapping("/producto/editar/{idProducto}")
    private String verProductoPorId(@PathVariable("idProducto") Integer idProducto, Model model){
        Producto producto = productoService.verProductoPorId(idProducto);
        model.addAttribute("producto", producto);
        return "actualizarproducto";
    }

    @PostMapping("/producto/actualizar/{idProducto}")
    private String editarProducto(@PathVariable("idProducto") Integer idProducto,Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/producto";
    }

    @GetMapping("producto/borrar/{idProducto}")
    private String eliminarproducto(@PathVariable("idProducto") Integer idProducto){
        productoService.eliminarProducto(idProducto);
        return "redirect:/producto";
    }


}





