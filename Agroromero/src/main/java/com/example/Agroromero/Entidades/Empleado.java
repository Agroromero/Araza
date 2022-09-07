package com.example.Agroromero.Entidades;

import javax.persistence.*;

@Entity
@Table(name = "")
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
        this.nombre = nombre;
        this.correo = correo;
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
        this.rolEmpleado = rolEmpleado;
        this.movimientodinero = movimientodinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresaEmpleadoPertenece() {
        return empresaEmpleadoPertenece;
    }

    public void setEmpresaEmpleadoPertenece(String empresaEmpleadoPertenece) {
        this.empresaEmpleadoPertenece = empresaEmpleadoPertenece;
    }

    public String getRolEmpleado() {
        return rolEmpleado;
    }

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
