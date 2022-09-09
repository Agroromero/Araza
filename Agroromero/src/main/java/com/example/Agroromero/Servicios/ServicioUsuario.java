package com.example.Agroromero.Servicios;
import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class ServicioUsuario {
    private RepositorioUsuario repositorioUsuario;
    public ServicioUsuario(RepositorioUsuario repositorioU){

        this.repositorioUsuario = repositorioU;
    }
    public List<Empleado> getInformacion(){

        return this.repositorioUsuario.findAll();
    }
    public Empleado crearUsuario(Empleado nuevoUsuario){

        return this.repositorioUsuario.save(nuevoUsuario);
    }
    public Empleado actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado e){
        Empleado empleadoActual = this.repositorioUsuario.findById(id).orElseThrow();
        empleadoActual.setCorreo((e.getCorreo()));
        empleadoActual.setNombre(e.getNombre());
        empleadoActual.setRolEmpleado(e.getRolEmpleado());
        empleadoActual.setEmpresaEmpleadoPertenece(e.getEmpresaEmpleadoPertenece());
        return this.repositorioUsuario.save(empleadoActual);
    }
    public Empleado eliminarEmpleado(Long id){
        Empleado empleadoActual = this.repositorioUsuario.findById(id).orElseThrow();
        this.repositorioUsuario.deleteById(id);
        return empleadoActual;
    }
}