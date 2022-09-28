package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Autenticacion;
import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Servicios.ServicioAutenticacion;
import com.example.Agroromero.Servicios.ServicioEmpresa;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ControladorEmpresa {

    ServicioEmpresa se1;


    public ControladorEmpresa(ServicioEmpresa se1){
        this.se1 = se1;
    }
/*
    @GetMapping("/empresa")
    public List<Empresa> informacion(){
        return this.se1.getInformacion();
    }
    */
/*
    @GetMapping("/empresa/{id}")
    public Empresa usuario(@PathVariable Long id){
        return this.se1.getUsuario(id);
    }

*/
/*
    @PostMapping("/empresa")
    public Empresa crearEmpresa(@RequestBody Empresa e){
        return this.se1.crearEmpresa(e);
    }
*/
    @PostMapping("/empresa")
    public RedirectView crearEmpresa(@ModelAttribute Empresa e, Model model){
        model.addAttribute(e);
        this.se1.crearEmpresa(e);
        return new RedirectView("/empresa");
    }

    @PutMapping("/empresa/{id}")
    public RedirectView actualizarEmpresa(@PathVariable Long id, Empresa e){
        this.se1.actualizarEmpresa(id, e);
        return new RedirectView("/empresa");
    }


    @DeleteMapping("/empresa/{id}")
    public RedirectView eliminarEmpresa(@PathVariable Long id){
        this.se1.eliminarEmpresa(id);
        return new RedirectView("/empresa");
    }



}
