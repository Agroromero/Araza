package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Servicios.ServicioMovimientoDinero;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorMovimientoDinero {

    ServicioMovimientoDinero smd1;

    public ControladorMovimientoDinero(ServicioMovimientoDinero smd1){
        this.smd1 = smd1;
    }

    @GetMapping("/movements")
    public List<MovimientoDinero> informacion(){
        return this.smd1.getInformacion();
    }

    @PostMapping("/movements")
    public MovimientoDinero crearEmpleado(@RequestBody MovimientoDinero md){
        return this.smd1.crearMovimientoDinero(md);
    }

    @PutMapping("/movements/{id}")
    public MovimientoDinero actualizarEmpresa(@PathVariable Long id, @RequestBody MovimientoDinero md){
        return this.smd1.actualizarMovimientoDinero(id, md);
    }

    @DeleteMapping("/movements/{id}")
    public MovimientoDinero eliminarEmpresa(@PathVariable(value = "id") Long id){
        return this.smd1.eliminarMovimientoDinero(id);
    }


}