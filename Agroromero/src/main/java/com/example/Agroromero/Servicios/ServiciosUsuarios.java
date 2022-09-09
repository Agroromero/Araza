package com.example.Agroromero.Servicios;

import com.example.Agroromero.Entidades.Empleado;

import javax.swing.*;

public class ServiciosUsuarios {

    Empleado E1;

    public ServiciosUsuarios(){
        this.E1 = new Empleado("Wes","wes@gmail.com","Araza","HR");
    }

    public String nombre(){
        return this.E1.getNombre();
    }
}
