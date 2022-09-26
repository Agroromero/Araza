package com.example.Agroromero.Entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movimientodinero")
public class MovimientoDinero {

    @Id
    private Long id;
    @Column(name = "montomovimiento")
    private double montoMovimiento;
    @Column(name = "conceptomovimiento")
    private String conceptoMovimiento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "documentoIdentidad",nullable = false) //debe relacionarlo con un empleado
    private Empleado empleadores;



    /*
    public MovimientoDinero(double montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

     */
    public MovimientoDinero(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empleado getEmpleadores() {
        return empleadores;
    }

    public void setEmpleadores(Empleado empleadores) {
        this.empleadores = empleadores;
    }

    public double getMontoMovimiento() {
        return montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setMontoMovimiento(double montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public double getSumaMovimientos(){
        ArrayList<Integer> documentos = new ArrayList<Integer>();
        documentos.add(this.empleadores.getDocumentoIdentidad().intValue());
        System.out.println(documentos.size());
        for(int i = 0; i < documentos.size(); i++){

        }
        //for(int i = 0; empleadores.getDocumentoIdentidad())
        //List<array> documentos = empleadores.getDocumentoIdentidad();
        return 10;
    }

    public int getCantidadMovimientos(){
        ArrayList<Integer> cantidad = new ArrayList<Integer>();
        cantidad.add(this.empleadores.getDocumentoIdentidad().intValue());
        System.out.println(cantidad.size());
        return cantidad.size();
    }
}
