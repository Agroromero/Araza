package com.example.Agroromero.Controladores;
import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Servicios.ServicioUsuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorUsuario {

    ServicioUsuario serviciosUsu;

    //Constructor

    public ControladorUsuario(ServicioUsuario serviciosUsu){
        this.serviciosUsu = serviciosUsu;

    }
    //Get
    @GetMapping("/user")
    public List<Empleado> user(){
        return this.serviciosUsu.getlistaEmpleado();
    }

    //Post
    @PostMapping("/user")
    public Empleado crearEmpleado(@RequestBody Empleado u){
        return this.serviciosUsu.crearEmpleado(u);
    }

    //editar un registro
    @PutMapping("/user/{id}")
    public Empleado actualizarPaciente(@PathVariable Long id,@RequestBody Empleado actEmpleado){
        return this.serviciosUsu.actualizarU(id, actEmpleado);

    }

    //borrar un registro
    @DeleteMapping("/eliminar/{id}")
    public Empleado eliminarEmpleado (@PathVariable(value = "id") Long id){
        return this.serviciosUsu.eliminarU(id);
    }

}

