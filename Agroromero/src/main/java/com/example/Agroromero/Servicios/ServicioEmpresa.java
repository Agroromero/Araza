package com.example.Agroromero.Servicios;

import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Repositorios.RepositorioEmpresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEmpresa {

    //ServicioUsuario se1 = new ServicioUsuario();

    private RepositorioEmpresa repositorioE;

    public ServicioEmpresa(RepositorioEmpresa repositorioE){
        this.repositorioE = repositorioE;
    }


    public List<Empresa> getInformacion(){
        return this.repositorioE.findAll();
    }
}
