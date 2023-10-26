package com.josepardo.tienda.controller;

import com.josepardo.tienda.entity.Categorias;
import com.josepardo.tienda.entity.Cliente;
import com.josepardo.tienda.entity.Venta;
import com.josepardo.tienda.repository.VentaRepository;
import com.josepardo.tienda.service.ClienteService;
import com.josepardo.tienda.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class VentaController {

    private VentaService ventaService;
    private ClienteService clienteService;

    @GetMapping("/venta")
    private String verVenta(Model model){
        model.addAttribute("ventas", ventaService.verVenta());
        return "venta";
    }

    @GetMapping("/agregarventa")
    private String   formularioVenta(Model model,Venta venta){
        List<Cliente> listClientes=clienteService.verCliente();
        model.addAttribute("clientes", listClientes);
        return "agregarventa";
    }

    @PostMapping("/venta")
    public String saveVenta(Venta venta){
        ventaService.saveVenta(venta);
        return "redirect:/venta";
    }

    @GetMapping("/venta/editar/{idVenta}")
    private String verClientePorId(@PathVariable("idVenta") Integer idVenta, Model model){
        Venta venta = ventaService.verVentaPorId(idVenta);
        model.addAttribute("venta", venta);
        return "actualizarventa";
    }

    @PostMapping("/venta/actualizar/{idVenta}")
    private String editarCategoria(@PathVariable("idVenta") Integer idVenta,Venta venta){
        ventaService.saveVenta(venta);
        return "redirect:/venta";
    }

    @GetMapping("venta/borrar/{idVenta}")
    private String eliminarCliente(@PathVariable("idVenta") Integer idVenta){
        ventaService.eliminarVennta(idVenta);
        return "redirect:/venta";
    }







}
