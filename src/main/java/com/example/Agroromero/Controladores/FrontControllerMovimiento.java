package com.example.Agroromero.Controladores;

import com.example.Agroromero.Entidades.Autenticacion;
import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Servicios.ServicioAutenticacion;
import com.example.Agroromero.Servicios.ServicioEmpresa;
import com.example.Agroromero.Servicios.ServicioMovimientoDinero;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControllerMovimiento {

    ServicioUsuario su1;
    ServicioMovimientoDinero smd1;
    ServicioAutenticacion sauth;
    ServicioEmpresa se1;

    public FrontControllerMovimiento(ServicioUsuario su1, ServicioMovimientoDinero smd1,
                                  ServicioAutenticacion sauth, ServicioEmpresa se1){
        this.su1 = su1;
        this.smd1 = smd1;
        this.sauth = sauth;
        this.se1 = se1;
    }

    @GetMapping("/movimiento/{id}")
    public String informacion(Model model, @AuthenticationPrincipal OidcUser principal, @PathVariable Long id){
        if(principal != null){
            Autenticacion usuario = this.sauth.getOrCreateAuth(principal.getClaims());
            model.addAttribute("auth", usuario);
        }
        List<MovimientoDinero> listaMovimientos = this.smd1.getInformacion();
        double balance = this.smd1.getbalance(id);
        List<Integer> cantidades = this.smd1.getCantidadMovimiento(id);
        Long nit = this.smd1.getNit(id);
        System.out.println("ESte es el nit " + nit.toString());
        model.addAttribute("listaDeMovimientos", listaMovimientos);
        model.addAttribute( "cedula", id);
        model.addAttribute( "nit", nit);
        model.addAttribute( "balance", balance);
        model.addAttribute( "positiva", cantidades.get(0));
        model.addAttribute( "negativa", cantidades.get(1));
        return "movimiento";
    }

    @GetMapping("/movimientoE/{id}")
    public String actualizarMovimiento(@PathVariable Long id, Model model){
        MovimientoDinero actualizar = this.smd1.getMovimiento(id);
        model.addAttribute( "actualizarMovi", actualizar);
        return "actualizarMovimiento";
    }

    @GetMapping("/movimiento/nuevo/{id}")
    public String nuevoMovimiento(@PathVariable Long id,Model model,
                                @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            Autenticacion usuario = this.sauth.getOrCreateAuth(principal.getClaims());
            model.addAttribute("auth", usuario);
        }
        model.addAttribute("nuevomovimientodinero", new MovimientoDinero());
        model.addAttribute( "cedula", id);
        return "nuevoMovimiento";
    }


}
