package com.example.Agroromero.Servicios;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.Empresa;
import com.example.Agroromero.Repositorios.RepositorioEmpresa;
import com.example.Agroromero.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repositorioU;

    public ServicioUsuario(RepositorioUsuario repositorioU){
        this.repositorioU = repositorioU;
    }


    public List<Empleado> getInformacion(){
        return this.repositorioU.findAll();
    }

    public Empleado crearUsuario(Empleado nuevoUsuario){
        return this.repositorioU.save(nuevoUsuario);
    }

    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado e){
        Empleado empleadoActual = this.repositorioU.findById(id).orElseThrow();
        empleadoActual.setCorreo((e.getCorreo()));
        empleadoActual.setNombre(e.getNombre());
        empleadoActual.setRolEmpleado(e.getRolEmpleado());
        empleadoActual.setEmpresaEmpleadoPertenece(e.getEmpresaEmpleadoPertenece());

        return this.repositorioU.save(empleadoActual);
    }

    public Empleado eliminarEmpleado(Long id){
        Empleado empleadoActual = this.repositorioU.findById(id).orElseThrow();
        this.repositorioU.deleteById(id);
        return empleadoActual;
    }
}
