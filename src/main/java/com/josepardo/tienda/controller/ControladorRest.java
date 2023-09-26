package com.josepardo.tienda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControladorRest {
    @GetMapping("/")
    public String saludar(){
        return "Mama estoy triunfando";
    }

    @GetMapping("/about")
    public String about(){
        return "Mi nombre es jose pardo";
    }
}
