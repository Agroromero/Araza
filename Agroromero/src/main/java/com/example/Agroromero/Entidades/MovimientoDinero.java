package com.example.Agroromero.Entidades;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
@Table(name = "movimientodinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "montomovimiento")
    private double montoMovimiento;
    @Column(name = "conceptomovimiento")
    private String conceptoMovimiento;

    public MovimientoDinero(double montoMovimiento, String conceptoMovimiento) {
=======
public class MovimientoDinero {

    private float montoMovimiento;
    private String conceptoMovimiento;

    public MovimientoDinero(float montoMovimiento, String conceptoMovimiento) {
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

<<<<<<< HEAD
    public void setMontoMovimiento(double montoMovimiento) {
=======
    public float getMontoMovimiento() {
        return montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
        this.montoMovimiento = montoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }
<<<<<<< HEAD
=======

    public double montos(){
        return -1;
    }

    public String usuarioEncargado(){
        return "-1";
    }
>>>>>>> 69f767f191b6f8224e504e3c8cd61aca7ebf2f0a
}
