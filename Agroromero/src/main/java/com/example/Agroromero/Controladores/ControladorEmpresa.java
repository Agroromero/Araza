package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Servicios.ServicioEmpresa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorEmpresa {

    ServicioEmpresa se1;


    public ControladorEmpresa(ServicioEmpresa se1){
        this.se1 = se1;
    }

    @GetMapping("/informacion")
    public List<Empresa> informacion(){
        return this.se1.getInformacion();
    }
}
