package com.example.Agroromero.Entidades;

public class MovimientoDinero {

    private float montoMovimiento;
    private String conceptoMovimiento;

    public MovimientoDinero(float montoMovimiento, String conceptoMovimiento) {
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public float getMontoMovimiento() {
        return montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public double montos(){
        return -1;
    }

    public String usuarioEncargado(){
        return "-1";
    }
}
