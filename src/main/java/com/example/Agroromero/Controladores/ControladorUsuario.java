package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.List;

@RestController
public class ControladorUsuario {

    ServicioUsuario su1;


    public ControladorUsuario(ServicioUsuario su1){
        this.su1 = su1;
    }
/*
    @GetMapping("/user")
    public List<Empleado> informacion(){
        return this.su1.getInformacion();
    }

 */

/*
    @PostMapping("/user")
//    public Empleado crearEmpleado(@RequestBody Empleado e, Model model){
    public Empleado crearEmpleado(@ModelAttribute Empleado e, Model model){
        model.addAttribute(e);
        return this.su1.crearUsuario(e);
    }
*/
/*
    @GetMapping("/user/{id}")
    public Empleado usuario(@PathVariable Long id){
        return this.su1.getUsuario(id);
    }
*/
    @PostMapping("/user")
    public RedirectView crearEmpleado(@ModelAttribute Empleado e, Model model){
        model.addAttribute(e);
        this.su1.crearUsuario(e);
        return new RedirectView("/user");
    }

    @PostMapping("/user/{id}")
    public RedirectView crearEmpleadoId(@PathVariable Long id, @ModelAttribute Empleado e, Model model){
        model.addAttribute(e);
        this.su1.crearUsuario(e);
        return new RedirectView("/user/"+id);
    }
    /*
        @PutMapping("/user/{id}")
        public Empleado actualizarEmpresa(@PathVariable Long id, @RequestBody Empleado e){
            return this.su1.actualizarEmpleado(id, e);
        }
 */
    @PutMapping("/usern/{id}")
    public RedirectView actualizarDatos(@PathVariable Long id, Empleado e){
        this.su1.actualizarEmpleado(id, e);
        Long nit = this.su1.getUsuario(id).getEmpresa().getNit();
        return new RedirectView("/user/"+nit);
    }
/*
    @DeleteMapping("/user/{id}")
    public Empleado eliminarEmpresa(@PathVariable(value = "id") Long id){
        return this.su1.eliminarEmpleado(id);
    }
*/
    @DeleteMapping("/usern/{id}")
    //public RedirectView eliminarEmpleado(@PathVariable(value = "id") Long id){
    public RedirectView eliminarEmpleado(@PathVariable Long id){
        Long nit = this.su1.getUsuario(id).getEmpresa().getNit();
        this.su1.eliminarEmpleado(id);
        return new RedirectView("/user/"+nit);
    }

}
