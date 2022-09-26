package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Servicios.ServicioEmpresa;
import com.example.Agroromero.Servicios.ServicioMovimientoDinero;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontController {

    ServicioUsuario su1;
    ServicioMovimientoDinero smd1;

    public FrontController(ServicioUsuario su1, ServicioMovimientoDinero smd1){
        this.su1 = su1;
        this.smd1 = smd1;
    }


    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/user")
    public String informacion(Model model){
        List<Empleado> listaEmpleados = this.su1.getInformacion();
        List<MovimientoDinero> lsitamovimientos = this.smd1.getInformacion();
        model.addAttribute("listaDeEmpleados", listaEmpleados);
        model.addAttribute("listaDeMovimientos", lsitamovimientos);
        return "usuarios";
    }

    @GetMapping("/user/nuevo")
    public String nuevoEmpleado(Model model){
        model.addAttribute("nuevoempleado", new Empleado());
        return "nuevoUsuario";
    }

    @GetMapping("/user/{id}")
    public String actualizarEmpleado(@PathVariable Long id, Model model){
        Empleado actualizar = this.su1.getUsuario(id);
        model.addAttribute( "actualizarE", actualizar);
        return "actualizarUsuario";
    }

    @GetMapping("/user/nuevo-movimiento")
    public String nuevoMovimiento(Model model){
        model.addAttribute("nuevomovimiento", new MovimientoDinero());
        return "nuevoMovimiento";
    }
/*
    @GetMapping("/user/nuevo-movimiento/{id}")
    public String actualizarmovimiento(@PathVariable Long id, Model model){
        MovimientoDinero actualizar = this.smd1.getMovimiento(id);
        model.addAttribute( "actualizarM", actualizar);
        return "actualizarUsuario";
    }

 */
}
