/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.objetos;

import java.awt.Component;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author James
 */
public abstract class Vehiculo implements Cloneable, Serializable{
    private String nombreVehiculo;
    private float punteria;
    private int hp;
    private int hpEnBatalla;
    private int pp;
    private int nivel;
    private int defensa;
    private int ataque;
    private int experiencia;
    private int turnos;
    private boolean estado;
    private boolean boot;
    private JLabel imagen;
    private List<Arma> armas;
    private List<String> enemigosDestruidos;
    private final int HP_INICIAL = 50;
    public final int HP = 50;
    public final int PP = 5;
    public final int NIVEL = 1;
    public final int EXPERIENCIA = 0;

    public Vehiculo(String nombreVehiculo, JLabel imagen, boolean boot) {
        this.nombreVehiculo = nombreVehiculo;
        this.imagen = imagen;
        this.boot = boot;
        this.armas  = new ArrayList<>();
        this.enemigosDestruidos  = new ArrayList<>();
        comprobarBoot();
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object objeto = null; 
        try {
            objeto = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("No se puede clonar");
        }
        return objeto;
    }

    private void comprobarBoot(){
        if (this.boot) {
            this.turnos = 3;
        }
    }

    public boolean isBoot() {
        return boot;
    }

    public void setBoot(boolean boot) {
        this.boot = boot;
    }
    
    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public float getPunteria() {
        return punteria;
    }

    public void setPunteria(float punteria) {
        this.punteria = punteria;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHpEnBatalla() {
        return hpEnBatalla;
    }

    public void setHpEnBatalla(int hpEnBatalla) {
        this.hpEnBatalla = hpEnBatalla;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void agregarArmas(Arma armas) {
        this.armas.add(armas);
    }

    public List<String> getEnemigosDestruidos() {
        return enemigosDestruidos;
    }

    public void agregarEnemigosDestruidos(String enemigosDestruidos) {
        this.enemigosDestruidos.add(enemigosDestruidos);
    }
    
    public  void comprobarExperiencia(Component component) {
        if (getExperiencia() >= (getNivel() * 100)) {
            setHp(HP_INICIAL*(getNivel()+1));
            setPp(getPp() + 3 + (2*getNivel()));
            setNivel(nivel + 1);
            setHpEnBatalla(getHp());
            JOptionPane.showMessageDialog(component, "Felicidades Subiste de Nivel: " + getNivel() + "\nHP: " + getHpEnBatalla() + "\nPP: " + getPp() + "\nXP: " + getExperiencia());
            subidaDeNivel();
        } 
    }
    
    public abstract void subidaDeNivel();

    public abstract void ataqueSubidaDeNivel(int ataque);

    public abstract void defensaSubidaDeNivel(int defensa);

    public abstract void punteriaSubidaDeNivel(float punteria);

    public abstract  void movimientoEspecial();

    public abstract  void agregarValoresIniciales();
    
}
