/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.objetos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import proyectofinal.ui.formularios.FrameBatalla;

/**
 *
 * @author James
 */
public class Batalla {
    private Random random;
    private Jugador jugador;
    private List<Vehiculo> vehiculosUtilizados;
    private Vehiculo vehiculoSeleccionado;
    private Arma armaSeleccionada;
    private Escenario escenario;
    private FrameBatalla frameBatalla; 
    private int posicionJugadorX;
    private int posicionJugadorY;
    private Enemigo enemigoEnTurno;
    private int ataqueMasBonus;
    private boolean ataqueEspecialAvion;

    public Batalla(Jugador jugador, Vehiculo vehiculoSeleccionado, Escenario escenario, FrameBatalla frameBatalla, int posicionJugadorX, int posicionJugadorY) {
        this.jugador = jugador;
        this.vehiculosUtilizados = new ArrayList<>();
        this.random = new Random();
        this.vehiculoSeleccionado = vehiculoSeleccionado;
        this.escenario = escenario;
        this.frameBatalla = frameBatalla;
        this.posicionJugadorX = posicionJugadorX;
        this.posicionJugadorY = posicionJugadorY;
    }

    public void setEnemigoEnTurno(Enemigo enemigoEnTurno) {
        this.enemigoEnTurno = enemigoEnTurno;
    }

    public void setAtaqueMasBonus(int ataqueMasBonus) {
        this.ataqueMasBonus = ataqueMasBonus;
    }

    public void setAtaqueEspecialAvion(boolean ataqueEspecialAvion) {
        this.ataqueEspecialAvion = ataqueEspecialAvion;
    }
    
    
   public void recompensa() {
       int oro;
       int xp;
       oro = (random.nextInt(25) + 35);
       xp = (random.nextInt(25) + 25);
       jugador.setOro(jugador.getOro()  + oro);
       JOptionPane.showMessageDialog(frameBatalla, "Felicidades Ganaste... \nOro Asignado a Jugador: " + oro);
       for (int i = 0; i < vehiculosUtilizados.size(); i++) {
           JOptionPane.showMessageDialog(frameBatalla, "\nVehiculo: " + vehiculosUtilizados.get(i).getNombreVehiculo()+ " \nExperiencia Asignada = " + xp + "\nHP: " + vehiculosUtilizados.get(i).getHpEnBatalla() +"\nXP: " + vehiculosUtilizados.get(i).getExperiencia() + xp);
           vehiculosUtilizados.get(i).setExperiencia(vehiculosUtilizados.get(i).getExperiencia() +xp);
           vehiculosUtilizados.get(i).comprobarExperiencia(frameBatalla);
       }
   }
   
   public void comprobacionFinDeJuego(int turno, boolean fin) {
       if (fin == true) {
           switch (turno) {
           case 1:
               jugador.setContadorPerdidos(jugador.getContadorPerdidos() + 1);
               jugador.perdio();
               JOptionPane.showMessageDialog(frameBatalla, "Lo siento has perdido mejor suerte para la proxima...");
               frameBatalla.setVisible(false);
               break;
           case 2:
               jugador.setContadorGanados(jugador.getContadorGanados() +1);
               recompensa();
               frameBatalla.setVisible(false);
               break;
           default:
               throw new AssertionError();
           }
       }
   }
   
   /*
   Metodo Inicial Batalla
    Realiza el ataque dirigido al enemigo
    */
    public void atacarEnemigoYJugador(int caso, boolean ataqueEspecial, int direccionAtaque, Arma armaSeleccionada, int bonusAtaque, JLabel [][] matrizLbl) {
        int eleccion  = direccionAtaque;
//        seleccionarArma(caso);
        if (caso == 2) {
            eleccion = random.nextInt(4) + 1;
        } 
        realizarAtaque(caso, armaSeleccionada, eleccion, ataqueEspecial, bonusAtaque, matrizLbl);
//        switch (eleccion) {
//            case 1:
//                realizarAtaque(caso, armaSeleccionada, 1, ataqueEspecial);
//                break;
//            case 2:
//                realizarAtaque(caso, armaSeleccionada, 2, ataqueEspecial);
//                break;
//            case 3:
//                realizarAtaque(caso, armaSeleccionada, 3, ataqueEspecial);
//                break;
//            case 4:
//                realizarAtaque(caso, armaSeleccionada, 4, ataqueEspecial);
//                break;
//            default:
//                throw new AssertionError();
//        }
    }

   
   /*
   Comprueba si el jugador aun posee vehiculos deiponibles para la batalla
   */
   public void comprobarSiAunTieneVehiculosDisponibles() {
       int contadorVehiculosDisponibles = 0;
       contadorVehiculosDisponibles = jugador.getVehiculosEnBatallas().stream().filter((vehiculo) -> (vehiculo.isEstado() == false)).map((_item) -> 1).reduce(contadorVehiculosDisponibles, Integer::sum);
       if (contadorVehiculosDisponibles == jugador.getVehiculosEnBatallas().size()) {
           comprobacionFinDeJuego(1, true);
       }
   }
   
       /*
    Muestra a los enemigos dentro del esenario sus posicion, vida y vehiculo
    */
    public void mostarEnemigosEnEscenario() {
        System.out.println("\nEnemigos en el Escenario: ");
        escenario.getEnemigos().stream().map((enemigo) -> {
            frameBatalla.agregarTexto("\nEnemigo Posición: [" + enemigo.getPosicionX() + ", "+ enemigo.getPosicionY() +"]");
            return enemigo;
        }).forEachOrdered((enemigo) -> {
            if (enemigo.getVehiculo().isEstado() == true) {
                frameBatalla.agregarTexto(" Estado: Activo");
            } else {
                System.out.println(" Estado: Destruido");
            }
//            mostrarVehiculo(enemigo.getVehiculo(), "Enemigo");
        });
    }

    public void setVehiculoSeleccionado(Vehiculo vehiculoSeleccionado) {
        this.vehiculoSeleccionado = vehiculoSeleccionado;
    }
    
    public int comprobarDefensaYHacerDanio(int caso, Arma arma, Enemigo enemigoAtacar, boolean ataqueEspecial, int bonusAtaque) {
        if (ataqueEspecial == true && caso == 2) {
            if (vehiculoSeleccionado instanceof Avion) {
                ataqueEspecialAvion = true;
                return (int) ((arma.getDanio()*bonusAtaque/100)+(arma.getDanio())*((1 - (enemigoAtacar.getVehiculo().getDefensa()/100)))*((Avion)vehiculoSeleccionado).getVelocidad()/2);
            } else {
                return (int) ((arma.getDanio()*bonusAtaque/100)+arma.getDanio()*2*((1 - (enemigoAtacar.getVehiculo().getDefensa()/100))));
            }
        } else {
            switch (caso) {
            case 1:
                if (vehiculoSeleccionado instanceof Avion) {
                    return (int) (arma.getDanio()*((1 - (enemigoAtacar.getVehiculo().getDefensa()/100)))*((Avion)vehiculoSeleccionado).getVelocidad());
                } else {
                    return (arma.getDanio()*(1 - (enemigoAtacar.getVehiculo().getDefensa()/100)));
                }
            case 2:
                if (enemigoAtacar.getVehiculo() instanceof Avion) {
                    return (int) (arma.getDanio()*(1 - (vehiculoSeleccionado.getDefensa()/100))*((Avion)enemigoAtacar.getVehiculo()).getVelocidad());
                } else {
                    if (ataqueEspecialAvion == true) {
                        ataqueEspecialAvion = false;
                        return (arma.getDanio() * (1 - ((vehiculoSeleccionado.getDefensa()+5)/100)));
                    } else {
                        return (arma.getDanio() * (1 - (vehiculoSeleccionado.getDefensa()/100)));
                    }
                }
            default:
                throw new AssertionError();
        }
        }
    }
    
    /*
    Comprueba la puenteria y si esta en el rango realiza el ataque
    */
    public void comprobarPunteria(int caso, Enemigo enemigoAtacar, Arma arma, boolean ataqueEspecial, int bonusAtaque, JLabel [][] matrizLbl) {
        float punteria  = random.nextInt(100) +1 ;
        if (arma.getMuniciones() <= 0) {
            JOptionPane.showMessageDialog(frameBatalla, "Lo siento tu arma ya no posee municiones");
        } else {
             arma.setMuniciones(arma.getMuniciones()-1);
            switch (caso) {
                case 1:
                    if (punteria <= vehiculoSeleccionado.getPunteria()) {
                        if (enemigoAtacar.getVehiculo().getHpEnBatalla() - comprobarDefensaYHacerDanio(2, arma, enemigoAtacar, ataqueEspecial,bonusAtaque) <= 0) {
                            escenario.getTerrenos()[enemigoAtacar.getPosicionX()][enemigoAtacar.getPosicionY()] = 6;
                            enemigoAtacar.getVehiculo().setHpEnBatalla(0);
                            enemigoAtacar.getVehiculo().setEstado(false);
                            escenario.getTerrenos()[enemigoAtacar.getPosicionX()][enemigoAtacar.getPosicionY()] = 6;
                            frameBatalla.agregarTexto("\nEnemigo posición: [" + enemigoAtacar.getPosicionX() + ", " + enemigoAtacar.getPosicionY() + "]");
                            frameBatalla.agregarTexto("Destruido");
                            escenario.asignarColorImprimir(enemigoAtacar.getPosicionX(), enemigoAtacar.getPosicionY(), 4, matrizLbl, escenario.getTerrenos());
                            vehiculoSeleccionado.agregarEnemigosDestruidos("\nEnemigo Destruido: " + enemigoAtacar.getVehiculo().getNombreVehiculo() + "\nEscenario: " + escenario.getNombreEscenario());
                        } else {
                            enemigoAtacar.getVehiculo().setHpEnBatalla(enemigoAtacar.getVehiculo().getHpEnBatalla() - comprobarDefensaYHacerDanio(2, arma, enemigoAtacar, ataqueEspecial, bonusAtaque));
                            JOptionPane.showMessageDialog(frameBatalla, "Enemigo atacado su posición: [" + enemigoAtacar.getPosicionX() + ", " + enemigoAtacar.getPosicionY() + "]\n" +"Daño Realizado = " + comprobarDefensaYHacerDanio(2, arma, enemigoAtacar, ataqueEspecial, bonusAtaque)+ "\nHP = " + enemigoAtacar.getVehiculo().getHpEnBatalla());
                            frameBatalla.agregarTexto("\nEnemigo atacado su posición: [" + enemigoAtacar.getPosicionX() + ", " + enemigoAtacar.getPosicionY() + "]\n" );
                            frameBatalla.agregarTexto("Daño Realizado = " + comprobarDefensaYHacerDanio(2, arma, enemigoAtacar, ataqueEspecial, bonusAtaque));
                            frameBatalla.agregarTexto("HP = " + enemigoAtacar.getVehiculo().getHpEnBatalla());
                        }
                    } else {
                        JOptionPane.showMessageDialog(frameBatalla, "UFF Mala suerte tu punteria no estuvo acertada");
                    }
                    break;
                case 2:
                    if (punteria <= enemigoAtacar.getVehiculo().getPunteria() ) {
                        if (vehiculoSeleccionado.getHpEnBatalla() - comprobarDefensaYHacerDanio(caso, arma, enemigoAtacar, ataqueEspecial, 0) <= 0) {
                            vehiculoSeleccionado.setHpEnBatalla(0);
                            vehiculoSeleccionado.setEstado(false);
                            JOptionPane.showMessageDialog(frameBatalla, "Vehiculo del jugador: " + vehiculoSeleccionado.getNombreVehiculo()+ "\nDestruido");
                        } else {
                            vehiculoSeleccionado.setHpEnBatalla(vehiculoSeleccionado.getHpEnBatalla() - comprobarDefensaYHacerDanio(1, arma, enemigoAtacar, ataqueEspecial, 0));
                            JOptionPane.showMessageDialog(frameBatalla, "Jugador Atacado \nDaño Realizado = "+  comprobarDefensaYHacerDanio(1, arma, enemigoAtacar, ataqueEspecial, 0)+ "\nHP = " + vehiculoSeleccionado.getHpEnBatalla());
                            frameBatalla.agregarTexto("\nJugador Atacado");
                            frameBatalla.agregarTexto("Daño Realizado = " + comprobarDefensaYHacerDanio(1, arma, enemigoAtacar, ataqueEspecial, 0));
                            frameBatalla.agregarTexto("HP = " + vehiculoSeleccionado.getHpEnBatalla());
                        }
                    } else {
                        frameBatalla.agregarTexto("\nUFF La punteria del enemigo no estuvo acertada");
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
       
    }
    
    public void ataqueEnemigos(JLabel [][] matrizLbl) {
        int  bandera = 0;
        Random random = new Random();
        bandera = jugador.getVehiculosEnBatallas().stream().filter((vehiculo) -> (vehiculo.isEstado() == false)).map((_item) -> 1).reduce(bandera, Integer::sum);
                if (bandera == jugador.getVehiculosEnBatallas().size()) {
                    comprobacionFinDeJuego(1, true);
                } else {
                    escenario.getEnemigos().forEach((enemigo) -> {
                        if (enemigo.getVehiculo().isEstado() == false) {
                            frameBatalla.agregarTexto("Destruido no puede realizar ataques");
                        } else {
                            enemigoEnTurno = enemigo;
                            frameBatalla.agregarTexto("Posición enemigo = [" + enemigoEnTurno.getPosicionX() + ", " + enemigoEnTurno.getPosicionY() + "]");
                            atacarEnemigoYJugador(2, false, ( 1 + random.nextInt(4) ) , enemigoEnTurno.getVehiculo().getArmas().get(random.nextInt(enemigoEnTurno.getVehiculo().getArmas().size())), 0, matrizLbl);
                        }
            });
                }
    }

    public void setPosicionJugadorX(int posicionJugadorX) {
        this.posicionJugadorX = posicionJugadorX;
    }

    public void setPosicionJugadorY(int posicionJugadorY) {
        this.posicionJugadorY = posicionJugadorY;
    }
    
    /*
    Comprueba la direccion de ataque ;
    */
    public boolean comprobarAtaque(int posicionX, int posicionY, int direccion) {
         switch (direccion) {
            case 1:
                return posicionX != 0;
            case 2:
                return posicionX != escenario.getValorM();
            case 3:
                return posicionY != 0;
            case 4:
                return posicionY != escenario.getValorN();
            default:
                throw new AssertionError();
        }
    }
    
    public String imprimirDireccion(int direccion) {
        switch (direccion) {
            case 1:
                return "Arriba";
            case 2:
                return "Abajo";
            case 3:
                return "Izquierda";
            case 4:
                return "Derecha";
            default:
                throw new AssertionError();
        }
    }
    
    /*
    Realiza las correspomdientes validaciones y si se cumplen se raliza el ataque al enemigo
    */
    public void realizarAtaque(int caso, Arma arma,  int direccion, boolean ataqueEspecial, int bonusAtaque, JLabel [][] matrizLbl) {
        switch (caso) {
            case 1:
                if (comprobarAtaque(posicionJugadorX, posicionJugadorY, direccion) == true) {
                    arma.setMuniciones(arma.getMuniciones()-1);
                     if (comprobarDistancia(direccion, posicionJugadorX, posicionJugadorY, caso, bonusAtaque) == true) {
                        comprobarPunteria(caso, enemigoEnTurno, arma, ataqueEspecial, bonusAtaque, matrizLbl);
                    } else {
                        JOptionPane.showMessageDialog(frameBatalla , "Lo siento tu ataque no ha llegado a dañar a un enmigo.");
                    }
                } else {
                    arma.setMuniciones(arma.getMuniciones()-1);
                    JOptionPane.showMessageDialog(frameBatalla , "Lo siento disparaste fuera del escenario...");
                }
                break;
            case 2:
                frameBatalla.agregarTexto("\nDirección ataque enemigo: " + imprimirDireccion(direccion));
                if (comprobarDistancia(direccion, enemigoEnTurno.getPosicionX(), enemigoEnTurno.getPosicionY(), caso, (((enemigoEnTurno.getVehiculo().getAtaque()*random.nextInt(100)+1)/100) + enemigoEnTurno.getVehiculo().getAtaque())) == true) {
                    comprobarPunteria(caso, enemigoEnTurno, arma, ataqueEspecial, 0, matrizLbl);
                } else {
                  frameBatalla.agregarTexto("\nEl ataque del enemigo no daño al jugador.");
                }
                break;
            case 3: 
                arma.setMuniciones(arma.getMuniciones()-1);
                if (comprobarAtaque(posicionJugadorX, posicionJugadorY, direccion) == true) {
//                    comprobarDistanciaTerreno(direccion, posicionJugadorX, posicionJugadorY, caso);
                } else {
                    System.out.println("\nLo siento disparaste fuera del escenario...");
                }
                break;
            default:
                throw new AssertionError();
        }
    }
    
    private int comprobacionDistancia(int escenarioValor, int primerComprobacion, int segundaComprobacion, int casoComprobacion, int enemigoJugador, int caso) {
        try {
             switch (casoComprobacion) {
            case 1:
                if (primerComprobacion < 0){
                    return 1;
                } else {
                    if (escenario.getTerrenos()[primerComprobacion][segundaComprobacion] == enemigoJugador) {
                         if (caso == 1) {
                             enemigoTurno(1, primerComprobacion, segundaComprobacion);
                         }
                        return 2;
                    } else {
                        return 3;
                    }
                }
            case 2:
                if (segundaComprobacion > escenarioValor-1) {
                    return 1;
                } else {
                     if (escenario.getTerrenos()[primerComprobacion][segundaComprobacion] == enemigoJugador) {
                       if (caso == 1) {
                             enemigoTurno(1, primerComprobacion , segundaComprobacion);
                         }
                         return 2;
                    } else {
                        return 3;
                    }
                }
            default:
                return  3;
        }
        } catch (Exception e) {
            return  3;
        }
    }
    
    //Comprueba la distancia de ataque 
    public boolean comprobarDistancia(int direccion, int posicionActualX, int posicionActualY, int caso, int ataqueMasBonus) {
        int enemigoJugador;
        if (caso == 1) {
            enemigoJugador = 5;
        } else {
            enemigoJugador = 4;
        }
        for (int i = 0; i < ataqueMasBonus; i++) {
            ataqueMasBonus = ataqueMasBonus - 4; 
            OUTER:
            OUTER_1:
            OUTER_2:
            OUTER_3:
            switch (direccion) {
                case 1:
                    switch (comprobacionDistancia(escenario.getValorM(), posicionActualX-i, posicionActualY, 1, enemigoJugador, caso)) {
                        case 1:
                            return false;
                        case 2:
                            return true;
                        default:
                            break OUTER;
                    }
                case 2:
                    switch (comprobacionDistancia(escenario.getValorM(), posicionActualX+i, posicionActualY, 2, enemigoJugador, caso)) {
                        case 1:
                            return false;
                        case 2:
                            return true;
                        default:
                            break OUTER_1;
                    }
                    //                    if ((posicionActualX+i) > escenarioBatalla.getValorM()-1) {
//                        return false;
//                    } else {
//                        if (escenarioBatalla.getTerrenos()[posicionActualX+i][posicionActualY] ==enemigoJugador) {
//                            if (caso == 1) {
//                                enemigoTurno(1, posicionActualX+i , posicionActualY);
//                            }
//                            return true;
//                        } else {
//                            break;
//                        }
//                    }
                case 3:
                    switch (comprobacionDistancia(escenario.getValorN(), posicionActualX, posicionActualY-i, 1, enemigoJugador, caso)) {
                        case 1:
                            return false;
                        case 2:
                            return true;
                        default:
                            break OUTER_1;
                    }
//                    if ((posicionActualY-i) < 0) {
//                        return false;
//                    } else {
//                        if (escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY-i] == enemigoJugador) {
//                            if (caso == 1) {
//                                enemigoTurno(1, posicionActualX, posicionActualY-i);
//                            }
//                            return true;
//                        } else {
//                            break;
//                        }
//                    }
                case 4:
                    switch (comprobacionDistancia(escenario.getValorN(), posicionActualX, posicionActualY+i, 2, enemigoJugador, caso)) {
                        case 1:
                            return false;
                        case 2:
                            return true;
                        default:
                            break OUTER_1;
                    }
//                    if ((posicionActualY+i) > escenarioBatalla.getValorN()-1) {
//                        return false;
//                    } else {
//                        if (escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY+i] == enemigoJugador) {
//                            if (caso == 1) {
//                                enemigoTurno(1, posicionActualX, posicionActualY+i);
//                            }
//                            return true;
//                        } else {
//                            break;
//                        }
//                    }
                default:
            }
            if (i == (ataqueMasBonus - 1)) {
                return false;
            }
        }
        return false;
    }
   
    public void enemigoTurno(int caso, int posicionEncontradaX, int posicionEncontradaY) {
        if (caso == 1) {
            escenario.getEnemigos().stream().filter((enemigo) -> (posicionEncontradaX == enemigo.getPosicionX() && posicionEncontradaY == enemigo.getPosicionY())).forEachOrdered((enemigo) -> {
                enemigoEnTurno = enemigo;
            });
        }
    }
    
    /*
    Comprieba de que el arma aun posea municiones 
    */
    public void comprobarMunicionesEnArma(int indice) {
        int contadorArmas = 0;
        contadorArmas = vehiculoSeleccionado.getArmas().stream().filter((armasEquipada) -> (armasEquipada.getMuniciones() > 0)).map((_item) -> 1).reduce(contadorArmas, Integer::sum);
        if (contadorArmas == 0) {
            System.out.println("Lo siento las armas del vehículo ya no tienen municiones...");
//            turnos(1);
        } else {
            if (vehiculoSeleccionado.getArmas().get(indice).getMuniciones() <= 0) {
            System.out.println("\nNo puedes seleccionar este arma porque ya no posee municiones");
//            seleccionarArma(1);
            } else {
                armaSeleccionada = vehiculoSeleccionado.getArmas().get(indice);
                System.out.println("\nArma Seleccionada: " + armaSeleccionada.getNombreDelArma());
            }
        }
    }
    
//    /*
//    Seleccion de armamaento para destruir enemigos, terrenos
//    */
//    public void seleccionarArma(int caso) {
//        switch (caso) {
//            case 1:
//                System.out.println("\nElije un arma para atacar: ");
//                for (int i = 0; i < vehiculoDeTurno.getArmasEquipadas().length; i++) {
//                    System.out.println("\nOpción: " + (i+1));
//                    vehiculoDeTurno.getArmasEquipadas()[i].mostrarInformacionArma();
//                }
//                comprobarMunicionesEnArma(Principal.leer.nextInt()-1);
//                break;
//            case 2:
//                int contadorArmas = enemigoEnTurno.getVehiculo().getArmasEquipadas().length;
//                armaSeleccionada = enemigoEnTurno.getVehiculo().getArmasEquipadas()[Principal.numerosAleatorios(enemigoEnTurno.getVehiculo().getArmasEquipadas().length) - 1];
//                while (armaSeleccionada.getMuniciones() <= 0) {
//                    if (contadorArmas == 0) {
//                        System.out.println("\nYa no hay armas con municiones.");
//                        enemigoEnTurno.getVehiculo().setEstado(false);
//                        break;
//                    } else {
//                        contadorArmas--;
//                    }
//                }
//                break;
//            case 3:
//                System.out.println("\nElije un arma para atacar: ");
//                for (int i = 0; i < vehiculoDeTurno.getArmasEquipadas().length; i++) {
//                    System.out.println("\nOpción: " + (i+1));
//                    vehiculoDeTurno.getArmasEquipadas()[i].mostrarInformacionArma();
//                }
//                comprobarMunicionesEnArma(Principal.leer.nextInt() - 1);
//                break;
//            default:
//                throw new AssertionError();
//        }
//    }
    
    /*
    Comprueba si aun queda vivo un enemigo dentro del escenario
    */
    public boolean comprobarEnemigosEnEscenario() {
        for (int i = 0; i < escenario.getValorM(); i++) {
            for (int j = 0; j < escenario.getValorN(); j++) {
                if (escenario.getTerrenos()[i][j] == 5) {
                    return false;
                } else if (i ==  (escenario.getValorM()-1) && j == escenario.getValorN()-1) {
                return true;
            }
            }
        }
        return true;
    }
//    
//    /*
//    Comprueba si en la direción de ataque del jugador logra eliminar un terreno
//    */
//    public void comprobarDistanciaTerreno(int direccion, int posicionActualX, int posicionActualY, int caso) {
//         for (int i = 0; i < ataqueMasBonus; i++) {
//            switch (direccion) {
//            case 1:
//                if ((posicionActualX-i) < 0){
//                    i = vehiculoDeTurno.getAtaque()-1;
//                    System.out.println("\nNo hay terrenos que se puedan destruir. ");
//                } else {
//                    if (escenarioBatalla.getTerrenos()[posicionActualX-i][posicionActualY] == 2 || escenarioBatalla.getTerrenos()[posicionActualX-i][posicionActualY] == 3 ) {
//                         escenarioBatalla.getTerrenos()[posicionActualX-i][posicionActualY] = 1;
//                         i = vehiculoDeTurno.getAtaque()-1;
//                         System.out.println("\nSe ha eliminado el terreno: ");
//                    } else {
//                        break;
//                    }
//                }
//                break;
//            case 2:
//                if ((posicionActualX+i) > escenarioBatalla.getValorM()-1) {
//                    i = vehiculoDeTurno.getAtaque()-1;
//                    System.out.println("\nNo hay terrenos que se puedan destruir. ");
//                } else {
//                     if (escenarioBatalla.getTerrenos()[posicionActualX+i][posicionActualY] == 3 || escenarioBatalla.getTerrenos()[posicionActualX+i][posicionActualY] == 2) {
//                       escenarioBatalla.getTerrenos()[posicionActualX+i][posicionActualY] = 1;
//                       i = vehiculoDeTurno.getAtaque()-1;
//                       System.out.println("\nSe ha eliminado el terreno: ");
//                    } else {
//                        break;
//                    }
//                }
//               break;
//            case 3:
//                if ((posicionActualY-i) < 0) {
//                     i = vehiculoDeTurno.getAtaque()-1;
//                     System.out.println("\nNo hay terrenos que se puedan destruir. ");
//                } else {
//                    if (escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY-i] == 3 || escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY-i] == 2) {
//                         escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY-i] = 1;
//                         i = vehiculoDeTurno.getAtaque()-1;
//                         System.out.println("\nSe ha eliminado el terreno: ");
//                    } else {
//                        break;
//                    }
//                }
//                break;
//            case 4:
//                if ((posicionActualY+i) > escenarioBatalla.getValorN()-1) {
//                     i = vehiculoDeTurno.getAtaque()-1;
//                     System.out.println("\nNo hay terrenos que se puedan destruir. ");
//                } else {
//                     if (escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY+i] == 3 || escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY+i] == 2) {
//                         escenarioBatalla.getTerrenos()[posicionActualX][posicionActualY+i] = 1;
//                         i = vehiculoDeTurno.getAtaque()-1;
//                         System.out.println("\nSe ha eliminado el terreno: ");
//                    } else {
//                        break;
//                    }
//                }
//                   break;
//            default:       
//            }
//        }
//         escenarioBatalla.asignarColorImprimir(escenarioBatalla.getValorM(), escenarioBatalla.getValorN(), escenarioBatalla.getTerrenos(), terrenoAnterior);
//    }
//    
//    public void movimientoEspecial() {
//        Enemigo enemigoAtaqueEspecial;
//        seleccionarArma(1);
//        if (vehiculoDeTurno instanceof Avion ) {
//            vehiculoDeTurno.setPp(vehiculoDeTurno.getPp() - 4);
//            for (Enemigo enemigo : escenarioBatalla.getEnemigos()) {
//                enemigoAtaqueEspecial = enemigo;
//                if (enemigo.getVehiculo().isEstado() == true) {
//                    comprobarPunteria(1, enemigo, armaSeleccionada, true);
//                } else {
//                    System.out.println("\nEnemigo destruido no se puede realizar el ataque especial.");
//                }
//            }
//        } else {
//            vehiculoDeTurno.setPp(vehiculoDeTurno.getPp() - 4);
//            int ataqueTemp = vehiculoDeTurno.getAtaque();
//            vehiculoDeTurno.setAtaque(vehiculoDeTurno.getAtaque() + escenarioBatalla.getValorM() + escenarioBatalla.getValorN());
//            atacarEnemigoYJugador(1, true);
//            vehiculoDeTurno.setAtaque(ataqueTemp);
//        }
//    }
}
