package Herramientas;

import java.util.Random;

import Juego.APrincipal;

public class Herramienta {

    int posicionX;
    int posicionY;
    
    public Herramienta() {
        setPosicionX();
        setPosicionY();
    }
    
    public int getPosicionX() {
        return posicionX;
    }


    public int getPosicionY() {
        return posicionY;
    }


    public void setPosicionX() {
        //Para que no se pueda generar justo debajo del jugador
        this.posicionX = new Random().nextInt((APrincipal.TAMANHO_MAPA - 2) + 1);
    }


    public void setPosicionY() {
      //Para que no se pueda generar justo debajo del jugador
        this.posicionY = new Random().nextInt((APrincipal.TAMANHO_MAPA - 2) + 1);
    }
}
