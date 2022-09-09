package com.example.Agroromero.Entidades;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "nit")
    private String nit;

    @Transient
    Empleado empleado;

    public Empresa(String nombre, String direccion, int telefono, String nit, Empleado empleado) {
=======
public class Empresa {
    private String nombre;
    private String direccion;
    private int telefono;
    private int nit;

    //Constructor


    public Empresa(String nombre, String direccion, int telefono, int nit) {
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
<<<<<<< HEAD
        this.empleado = empleado;
    }

=======
    }

    //getter y setter


>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

<<<<<<< HEAD
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", nit='" + nit + '\'' +
                ", empleado=" + this.empleado +
                '}';
    }
=======
    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
}
