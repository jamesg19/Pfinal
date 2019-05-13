/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.objetos;

import javax.swing.JLabel;

/**
 *
 * @author James
 */
public class Avion extends Vehiculo{
    private float velocidad;
    private final float VELOCIDAD_DE_DISPARO = 1f;
    private final int ATAQUE_INICIAL = 7;
    private final int DEFENSA_INICIAL = 3;
    private final int PUNTERIA_INICIAL = 70;

    public Avion(String nombreVehiculo, JLabel imagen, boolean boot) {
        super(nombreVehiculo, imagen, boot);
    }
    
    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void ataqueSubidaDeNivel(int ataque) {
        setAtaque(ataque+2);
    }

    @Override
    public void defensaSubidaDeNivel(int defensa) {
        setDefensa(defensa + 1);
    }

    @Override
    public void punteriaSubidaDeNivel(float punteria) {
        setPunteria(punteria + 0.5f);
    }
    
    @Override
    public void movimientoEspecial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void velocidadAtaqueSubidaDeNivel(float velocidadAtq){
        setVelocidad(velocidad + 0.1f);
    }

    @Override
    public void subidaDeNivel(){
        ataqueSubidaDeNivel(getAtaque());
        defensaSubidaDeNivel(getDefensa());
        punteriaSubidaDeNivel(getPunteria());
        velocidadAtaqueSubidaDeNivel(getVelocidad());
        System.out.println("\nNombre Vehiculo: " + super.getNombreVehiculo());
        System.out.println("Ataque: " + super.getAtaque());
        System.out.println("Defensa: " + getDefensa());
        System.out.println("Punteria: " + getPunteria());
        System.out.println("Velocidad: " + getVelocidad());
    }
    
    @Override
    public void agregarValoresIniciales() {
        super.setAtaque(ATAQUE_INICIAL);
        super.setDefensa(DEFENSA_INICIAL);
        super.setPunteria(PUNTERIA_INICIAL);
        setVelocidad(VELOCIDAD_DE_DISPARO);
        super.setExperiencia(EXPERIENCIA);
        super.setEstado(true);
        setHp(HP);
        setPp(PP);
        setNivel(NIVEL);
        setHpEnBatalla(getHp());
   }
   
}
