package com.example.Agroromero.Servicios;

import com.example.Agroromero.Entidades.Autenticacion;
import com.example.Agroromero.Repositorios.RepositorioAutenticacion;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class ServicioAutenticacion {

    private RepositorioAutenticacion repositorioAuth;

    public ServicioAutenticacion(RepositorioAutenticacion repositorioAuth){
        this.repositorioAuth = repositorioAuth;
    }

    public RepositorioAutenticacion getRepositorioAuth() {
        return repositorioAuth;
    }

    public void setRepositorioAuth(RepositorioAutenticacion repositorioAuth) {
        this.repositorioAuth = repositorioAuth;
    }

    public Autenticacion buscarPorEmail(String email){
        return this.repositorioAuth.findByEmail(email);
    }

    public Autenticacion crearCredencial(Autenticacion nuevaCredencial){
        return this.repositorioAuth.save(nuevaCredencial);
    }

    public Autenticacion getOrCreateAuth(Map<String, Object> DatosAuth){
        String email = DatosAuth.get("email").toString();
        Autenticacion usuario = buscarPorEmail(email);
        if(usuario == null){
            String nickname = DatosAuth.get("nickname").toString();
            String imagen = DatosAuth.get("picture").toString();
            String auth0Id = DatosAuth.get("sub").toString();

            Autenticacion nuevaCredencial = new Autenticacion(email = email, imagen = imagen,
                    auth0Id = auth0Id, nickname = nickname);
            return crearCredencial(nuevaCredencial);
        }
        return usuario;
    }
}
