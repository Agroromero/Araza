package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Servicios.ServicioMovimientoDinero;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
/*
    @PostMapping("/movements")
    public MovimientoDinero crearEmpleado(@RequestBody MovimientoDinero md){
        return this.smd1.crearMovimientoDinero(md);
    }
*/
    @PostMapping("/movimiento/{id}")
    public RedirectView crearMovimiento(@PathVariable Long id, @ModelAttribute MovimientoDinero md, Model model){
        model.addAttribute(md);
        this.smd1.crearMovimientoDinero(md);
        return new RedirectView("/movimiento/"+id);
    }

    @PutMapping("/movimienton/{id}")
    public RedirectView actualizarMovimiento(@PathVariable Long id, MovimientoDinero md){
        this.smd1.actualizarMovimientoDinero(id, md);
        Long cedula = this.smd1.getMovimiento(id).getEmpleadores().getDocumentoIdentidad();
        return new RedirectView("/movimiento/"+cedula);
    }

    @DeleteMapping("/movimiento/{id}")
    public RedirectView eliminarMovimiento(@PathVariable(value = "id") Long id){
        Long cedula = this.smd1.getMovimiento(id).getEmpleadores().getDocumentoIdentidad();
        this.smd1.eliminarMovimientoDinero(id);
        return new RedirectView("/movimiento/"+cedula);
    }


}
