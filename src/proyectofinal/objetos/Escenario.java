/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author James
 */
public class Escenario implements Serializable, Cloneable{
    private String nombreEscenario;
    private int terrenos [][];
    private int valorM;
    private int valorN;
    private List<Enemigo> enemigos = new ArrayList<>();

    public Escenario(String nombreEscenario, int[][] terrenos, int valorM, int valorN) {
        this.nombreEscenario = nombreEscenario;
        this.terrenos = terrenos;
        this.valorM = valorM;
        this.valorN = valorN;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public void agregarEnemigos(Enemigo enemigo) {
        this.enemigos.add(enemigo);
    }
    
    public int getValorM() {
        return valorM;
    }

    public void setValorM(int valorM) {
        this.valorM = valorM;
    }

    public int getValorN() {
        return valorN;
    }

    public void setValorN(int valorN) {
        this.valorN = valorN;
    }

    public String getNombreEscenario() {
        return nombreEscenario;
    }

    public void setNombreEscenario(String nombreEscenario) {
        this.nombreEscenario = nombreEscenario;
    }

    public int[][] getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(int[][] terrenos) {
        this.terrenos = terrenos;
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
    
    /*
    imprime la matriz en pantalla con colores
    */
     public void asignarColorImprimir(int i, int j, int terrenoAnterior, JLabel[][] matrizLbl, int[][] matriz){
                switch (matriz[i][j]) {
                   case 1:
                       matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Campo.png"));
                       break;
                   case 2:
                       matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Montaña.png"));
                       break;
                   case 3:
                       matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Lago.png"));
                       break;
                   case 4:
                        switch (terrenoAnterior) {
                            case 1:
                                matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Jugador_Campo.png"));
                                break;
                            case 2:
                                matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Jugador_Lago.png"));
                                break;
                            case 3:
                                matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Jugador_Montaña.png"));
                                break;
                            default:
                                matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Campo.png"));
                        }
                        break;
                    case 5:
                        matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Enemigo.png"));
                        break;
                    case 6:
                        matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Enemigo_Destruido.png"));
                        break;
                    case 7:
                        matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Campo.png"));//Bonus
                        break;
                    case 8:
                        matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Boot.png"));
                        break;
                    default:
                        matrizLbl[i][j].setIcon(new ImageIcon("Imagenes/Campo.png"));
                }
    }
}
