/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.objetos;

import java.io.Serializable;

/**
 *
 * @author James
 */
public class Enemigo implements Serializable{
    private Vehiculo vehiculo;
    private int posicionX;
    private int posicionY;

    public Enemigo(Vehiculo vehiculo, int posicionX, int posicionY) {
        this.vehiculo = vehiculo;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}
