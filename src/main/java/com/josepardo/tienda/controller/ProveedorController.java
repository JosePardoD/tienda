package com.josepardo.tienda.controller;


import com.josepardo.tienda.entity.Producto;
import com.josepardo.tienda.entity.Proveedor;
import com.josepardo.tienda.service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProveedorController {

    private ProveedorService proveedorService;
    @GetMapping("/proveedor")
    private String verProveedor(Model model){
        model.addAttribute("proveedores", proveedorService.verProveedor());
        return "proveedor";
    }

    @GetMapping("/agregarproveedor")
    private String   formularioProveedor(Proveedor proveedor){
        return "agregarproveedor";
    }

    @PostMapping("/proveedor")
    public String saveProveedor(Proveedor proveedor){
        proveedorService.saveProveedor(proveedor);
        return "redirect:/proveedor";
    }

    @GetMapping("/proveedor/editar/{idProveedor}")
    private String verProveedorPorId(@PathVariable("idProveedor") Integer idProveedor, Model model){
        Proveedor proveedor = proveedorService.verProveedorPorId(idProveedor);
        model.addAttribute("proveedor", proveedor);
        return "actualizarproveedor";
    }

    @PostMapping("/proveedor/actualizar/{idProveedor}")
    private String editarProducto(@PathVariable("idProveedor") Integer idProveedor,Proveedor proveedor){



        proveedorService.saveProveedor(proveedor);
        return "redirect:/proveedor";
    }

    @GetMapping("proveedor/borrar/{idProveedor}")
    private String eliminarproducto(@PathVariable("idProveedor") Integer idProveedor){
        proveedorService.eliminarProveedor(idProveedor);
        return "redirect:/proveedor";
    }


}
