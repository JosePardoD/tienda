package com.josepardo.tienda.controller;

import com.josepardo.tienda.entity.*;
import com.josepardo.tienda.service.*;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@AllArgsConstructor
public class CarritoController {

    private  ProductoService productoService;
    private ProductoVentaService productoVentaService;
    private VentaService ventaService;
    private ClienteService clienteService;
    private CategoriasService categoriasService;



    @GetMapping("/productoventa")
    private String formularioProducto(Model model,ProductosVenta productosVenta){
        List<Venta> listVenta=ventaService.verVenta();
        model.addAttribute("ventas", listVenta);

        List<Producto> listproductos=productoService.verProducto();
        model.addAttribute("productos", listproductos);
        return "productoventa";
    }

    @PostMapping("/productoventa")
    public String saveProductoVenta(ProductosVenta productosVenta, @RequestParam Integer iProductoVenta,@RequestParam Integer cantidad){

        //System.out.println(productosVenta);
        productoVentaService.saveProductoVenta(productosVenta);

        ProductosVenta productosVenta1=new ProductosVenta();
        ProductosVenta productosVenta2=new ProductosVenta();
        Optional<ProductosVenta> optionalProductosVenta=productoVentaService.getProductoVenta(iProductoVenta);
        productosVenta1=optionalProductosVenta.get();




        productosVenta2.setPrecio(productosVenta1.getProducto().getPrecio());
        productosVenta2.setTotal(productosVenta1.getProducto().getPrecio()*cantidad);
        productosVenta2.setVenta(productosVenta1.getVenta());
        productosVenta2.setProducto(productosVenta1.getProducto());
        productosVenta2.setCantidad(productosVenta1.getCantidad());
        productosVenta2.setCantidad(productosVenta1.getIProductoVenta());

        productoVentaService.saveProductoVenta(productosVenta2);
        productoVentaService.eliminarProductoVenta(iProductoVenta);


        return "redirect:/productoventa";
    }
}
