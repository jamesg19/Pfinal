/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class Jugador implements Serializable, Cloneable{
    private int oro;
    private int contadorGanados;
    private int contadorPerdidos;
    private Escenario escenarioModificado;
    private String nombreJugador;
    private List<Vehiculo> vehiculosEnBatallas;
    private List<Vehiculo> vehiculosBoots;
    private List<Objetos> objetos;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.oro = 100;
        this.contadorGanados = 0;
        this.contadorPerdidos = 0;
        this.objetos = new ArrayList<>();
        this.vehiculosBoots = new ArrayList<>();
        this.vehiculosEnBatallas = new ArrayList<>();
    }

    public Jugador() {
    }

    public Escenario getEscenarioModificado() {
        return escenarioModificado;
    }

    public void setEscenarioModificado(Escenario escenarioModificado) {
        this.escenarioModificado = escenarioModificado;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getContadorGanados() {
        return contadorGanados;
    }

    public void setContadorGanados(int contadorGanados) {
        this.contadorGanados = contadorGanados;
    }

    public int getContadorPerdidos() {
        return contadorPerdidos;
    }

    public void setContadorPerdidos(int contadorPerdidos) {
        this.contadorPerdidos = contadorPerdidos;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public List<Vehiculo> getVehiculosEnBatallas() {
        return vehiculosEnBatallas;
    }

    public List<Vehiculo> getVehiculosBoots() {
        return vehiculosBoots;
    }

    public List<Objetos> getObjetos() {
        return objetos;
    }

    public void agregarVehiculosEnBatallas(Vehiculo vehiculo) {
        this.vehiculosEnBatallas.add(vehiculo);
    }

    public void agregarVehiculosBoots(Vehiculo vehiculoBoot) {
        this.vehiculosBoots.add(vehiculoBoot);
    }

    public void agregarObjetos(Objetos objeto) {
        this.objetos.add(objeto);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException  {
        Object objeto = null; 
        try {
            objeto = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("No se puede clonar");
        }
        return objeto;
    }

    void perdio() {
        this.vehiculosEnBatallas.forEach((vehiculosEnBatalla) -> {
            vehiculosEnBatalla.agregarValoresIniciales();
        });
    }
}
