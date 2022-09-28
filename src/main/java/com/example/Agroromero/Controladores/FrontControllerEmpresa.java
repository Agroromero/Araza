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
public class FrontControllerEmpresa {


    ServicioUsuario su1;
    ServicioMovimientoDinero smd1;
    ServicioAutenticacion sauth;
    ServicioEmpresa se1;

    public FrontControllerEmpresa(ServicioUsuario su1, ServicioMovimientoDinero smd1,
                                  ServicioAutenticacion sauth, ServicioEmpresa se1){
        this.su1 = su1;
        this.smd1 = smd1;
        this.sauth = sauth;
        this.se1 = se1;
    }

    @GetMapping("/empresa")
    public String informacion(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            System.out.println(principal.getClaims());
            Autenticacion usuario = this.sauth.getOrCreateAuth(principal.getClaims());
            model.addAttribute("auth", usuario);
        }
        List<Empresa> listaEmpresas = this.se1.getInformacion();
        model.addAttribute("listaDeEmpresas", listaEmpresas);
        return "empresa";
    }

    @GetMapping("/empresa/{id}")
    public String actualizarEmpresa(@PathVariable Long id, Model model){
        Empresa actualizar = this.se1.getEmpresa(id);
        model.addAttribute( "actualizarEmpresa", actualizar);
        return "actualizarEmpresa";
    }

    @GetMapping("/empresa/nuevo")
    public String nuevaEmpresa(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal != null){
            Autenticacion usuario = this.sauth.getOrCreateAuth(principal.getClaims());
            model.addAttribute("auth", usuario);
        }
        model.addAttribute("nEmpresa", new Empresa());
        return "nuevaEmpresa";
    }

}
