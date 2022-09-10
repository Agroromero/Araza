package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ControladorUsuario {

    ServicioUsuario su1;


    public ControladorUsuario(ServicioUsuario su1){
        this.su1 = su1;
    }

    @GetMapping("/user")
    public List<Empleado> informacion(){
        return this.su1.getInformacion();
    }

    @PostMapping("/user")
    public Empleado crearEmpleado(@RequestBody Empleado e){
        return this.su1.crearUsuario(e);
    }

    @PutMapping("/user/{id}")
    public Empleado actualizarEmpresa(@PathVariable Long id, @RequestBody Empleado e){
        return this.su1.actualizarEmpleado(id, e);
    }

    @DeleteMapping("/user/{id}")
    public Empleado eliminarEmpresa(@PathVariable(value = "id") Long id){
        return this.su1.eliminarEmpleado(id);
    }

}
