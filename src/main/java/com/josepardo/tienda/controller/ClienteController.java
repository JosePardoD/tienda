package com.josepardo.tienda.controller;

import com.josepardo.tienda.entity.Categorias;
import com.josepardo.tienda.entity.Cliente;
import com.josepardo.tienda.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("/cliente")
    private String verCliente(Model model){
        model.addAttribute("clientes", clienteService.verCliente());
        return "cliente";
    }

    @GetMapping("/agregarcliente")
    private String   formularioCliente(Cliente cliente){
        return "agregarcliente";
    }

    @PostMapping("/cliente")
    public String saveCliente(Cliente cliente){
        clienteService.saveCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/editar/{idCliente}")
    private String verClientePorId(@PathVariable("idCliente") Integer idCliente, Model model){
        Cliente cliente = clienteService.verClientePorId(idCliente);
        model.addAttribute("cliente", cliente);
        return "actualizarcliente";
    }

    @PostMapping("/cliente/actualizar/{idCliente}")
    private String editarCategoria(@PathVariable("idCliente") Integer idCliente,Cliente cliente){
        clienteService.saveCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("cliente/borrar/{idCliente}")
    private String eliminarCliente(@PathVariable("idCliente") Integer idCliente){
        clienteService.eliminarCliente(idCliente);
        return "redirect:/cliente";
    }





}
