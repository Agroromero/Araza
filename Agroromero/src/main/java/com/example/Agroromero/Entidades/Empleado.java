package com.example.Agroromero.Entidades;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correo")
    private String correo;
    @Column(name = "empresaempleadopertenece")
    private String empresaEmpleadoPertenece;
    @Column(name = "rolempleado")
    private String rolEmpleado;

    @Transient
    MovimientoDinero movimientodinero;

    public Empleado(String nombre, String correo, String empresaEmpleadoPertenece, String rolEmpleado, MovimientoDinero movimientodinero) {
=======
public class Empleado {
    private String nombre;
    private String correo;
    private String empresaEmpleadoPertenece;
    private String rolEmpleado;

    public Empleado(String nombre, String correo, String empresaEmpleadoPertenece, String rolEmpleado) {
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
        this.nombre = nombre;
        this.correo = correo;
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
        this.rolEmpleado = rolEmpleado;
<<<<<<< HEAD
        this.movimientodinero = movimientodinero;
=======
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
    }

    public String getNombre() {
        return nombre;
    }

<<<<<<< HEAD
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

=======
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
    public String getCorreo() {
        return correo;
    }

<<<<<<< HEAD
    public void setCorreo(String correo) {
        this.correo = correo;
    }

=======
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
    public String getEmpresaEmpleadoPertenece() {
        return empresaEmpleadoPertenece;
    }

<<<<<<< HEAD
    public void setEmpresaEmpleadoPertenece(String empresaEmpleadoPertenece) {
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
    }

=======
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
    public String getRolEmpleado() {
        return rolEmpleado;
    }

<<<<<<< HEAD
    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public MovimientoDinero getMovimientodinero() {
        return movimientodinero;
    }

    public void setMovimientodinero(MovimientoDinero movimientodinero) {
        this.movimientodinero = movimientodinero;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", empresaEmpleadoPertenece='" + empresaEmpleadoPertenece + '\'' +
                ", rolEmpleado='" + rolEmpleado + '\'' +
                ", movimientodinero=" + this.movimientodinero +
                '}';
    }
}
=======
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setEmpresaEmpleadoPertenece(String empresaEmpleadoPertenece) {
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
    }

    public void setRolEmpleado(String rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}


>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
