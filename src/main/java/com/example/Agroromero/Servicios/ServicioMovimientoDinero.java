package com.example.Agroromero.Servicios;

import com.example.Agroromero.Entidades.Empleado;
import com.example.Agroromero.Entidades.MovimientoDinero;
import com.example.Agroromero.Repositorios.RepositorioMovimientoDinero;
import com.example.Agroromero.Repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ServicioMovimientoDinero {

    private RepositorioMovimientoDinero repositorioMD;

    public ServicioMovimientoDinero(RepositorioMovimientoDinero repositorioMD){
        this.repositorioMD = repositorioMD;
    }


    public List<MovimientoDinero> getInformacion(){
        return this.repositorioMD.findAll();
    }


    public double getbalance(Long id){
        List<MovimientoDinero> movimientos = this.repositorioMD.findAll();
        //System.out.println(movimientos.size());
        //System.out.println(movimientos.listIterator());
        double balance = 0;
        for (int i = 0; i < movimientos.size(); i++){
            if(movimientos.get(i).getEmpleadores().getDocumentoIdentidad() == id.intValue()){
          //      System.out.println(movimientos.get(i).getMontoMovimiento());
                balance = balance + movimientos.get(i).getMontoMovimiento();
            }
        }
        //System.out.println(balance);
        return balance;
    }

    public List<Integer> getCantidadMovimiento(Long id){
    //public void getCantidadMovimiento(Long id){
        List<MovimientoDinero> movimientos = this.repositorioMD.findAll();
        List<Integer> cantidades = Arrays.asList(0, 0);
        //System.out.println(cantidades.get(0));
        for (int i = 0; i < movimientos.size(); i++){
            if(movimientos.get(i).getEmpleadores().getDocumentoIdentidad() == id.intValue()){
                if(movimientos.get(i).getMontoMovimiento() >= 0){
                    cantidades.set(0, cantidades.get(0) + 1);
                }
                else{
                    cantidades.set(1, cantidades.get(1) + 1);
                }
            }
            //System.out.println("Cantidad positiva " + cantidades.get(0).toString());
            //System.out.println("cantidad negativa " + cantidades.get(1).toString());
        }
        return cantidades;
    }

    public Long getNit(Long id){
        List<MovimientoDinero> movimientos = this.repositorioMD.findAll();
        Long nit = 0L;
        for (int i = 0; i < movimientos.size(); i++){
            if(movimientos.get(i).getEmpleadores().getDocumentoIdentidad() == id.intValue()){
                //System.out.println(movimientos.get(i).getMontoMovimiento());
                nit = movimientos.get(i).getEmpleadores().getEmpresa().getNit();
                return nit;
            }
        }
        return nit;
    }

    public MovimientoDinero getMovimiento(Long id){
        return this.repositorioMD.findById(id).orElseThrow();
    }
    public MovimientoDinero crearMovimientoDinero(MovimientoDinero nuevoMovimientoDinero){
        return this.repositorioMD.save(nuevoMovimientoDinero);
    }

    public MovimientoDinero actualizarMovimientoDinero(@PathVariable Long id, @RequestBody MovimientoDinero md){
        MovimientoDinero movimientoDineroActual = this.repositorioMD.findById(id).orElseThrow();
        movimientoDineroActual.setConceptoMovimiento(md.getConceptoMovimiento());
        movimientoDineroActual.setMontoMovimiento(md.getMontoMovimiento());
        return this.repositorioMD.save(movimientoDineroActual);
    }

    public MovimientoDinero eliminarMovimientoDinero(Long id){
        MovimientoDinero movimientoDineroActual = this.repositorioMD.findById(id).orElseThrow();
        this.repositorioMD.deleteById(id);
        return movimientoDineroActual;
    }

}
