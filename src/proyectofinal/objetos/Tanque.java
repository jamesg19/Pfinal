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
public class Tanque extends Vehiculo{
    public final int ATAQUE_INICIAL = 10;
    public final int DEFENSA_INICIAL = 6;
    public final int PUNTERIA_INICIAL = 60;

    public Tanque(String nombreVehiculo, JLabel imagen, boolean boot) {
        super(nombreVehiculo, imagen, boot);
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

    @Override
    public void agregarValoresIniciales() {
        super.setAtaque(ATAQUE_INICIAL);
        super.setDefensa(DEFENSA_INICIAL);
        super.setPunteria(PUNTERIA_INICIAL);
        super.setExperiencia(EXPERIENCIA);
        super.setEstado(true);
        setHp(HP);
        setPp(PP);
        setNivel(NIVEL);
        setHpEnBatalla(getHp());
    }
    
    @Override
    public void subidaDeNivel() {
        ataqueSubidaDeNivel(getAtaque());
        defensaSubidaDeNivel(getDefensa());
        punteriaSubidaDeNivel(getPunteria());
        System.out.println("\nNombre Vehiculo: " + super.getNombreVehiculo());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defensa: " + getDefensa());
        System.out.println("Punteria: " + getPunteria());
    }
}
