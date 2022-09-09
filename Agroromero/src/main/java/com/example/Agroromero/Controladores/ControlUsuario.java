package com.example.Agroromero.Controladores;

import com.example.Agroromero.Servicios.ServiciosUsuarios;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlUsuario {


    ServiciosUsuarios services;

    //constructor del controlador
    public ControlUsuario(){
        this.services = new ServiciosUsuarios();
    }

    @GetMapping("/user")
    public String verUser(){
        return this.services.nombre();
    }

}




