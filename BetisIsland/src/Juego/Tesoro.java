package Juego;
import java.util.Random;

public class Tesoro{

	@Override
    public String toString() {
        return "Tesoro: Posicion X: " + posicionX + " | Posicion Y: " + posicionY;
    }


    int posicionX;
	int posicionY;
	
	public Tesoro() {
		setPosicionX();
		setPosicionY();
	}
	
	public Tesoro(int x, int y) {
		this.posicionX = x;
		this.posicionY = y;
	}
	
	
	public int getPosicionY() {
		return posicionY;
	}


	public int getPosicionX() {
		return posicionX;
	}


	public void setPosicionX() {
		this.posicionY = new Random().nextInt((APrincipal.TAMANHO_MAPA - 2) + 1);
	}


	public void setPosicionY() {
		this.posicionX = new Random().nextInt((APrincipal.TAMANHO_MAPA - 2) + 1);
	}
	
	public String verTesoro() {
	    return "*******************************************************************************\r\n"
	            + "          |                   |                  |                     |\r\n"
	            + " _________|________________.=\"\"_;=.______________|_____________________|_______\r\n"
	            + "|                   |  ,-\"_,=\"\"     `\"=.|                  |\r\n"
	            + "|___________________|__\"=._o`\"-._        `\"=.______________|___________________\r\n"
	            + "          |                `\"=._o`\"=._      _`\"=._                     |\r\n"
	            + " _________|_____________________:=._o \"=._.\"_.-=\"'\"=.__________________|_______\r\n"
	            + "|                   |    __.--\" , ; `\"=._o.\" ,-\"\"\"-._ \".   |\r\n"
	            + "|___________________|_._\"  ,. .` ` `` ,  `\"-._\"-._   \". '__|___________________\r\n"
	            + "          |           |o`\"=._` , \"` `; .\". ,  \"-._\"-._; ;              |\r\n"
	            + " _________|___________| ;`-.o`\"=._; .\" ` '`.\"\\` . \"-._ /_______________|_______\r\n"
	            + "|                   | |o;    `\"-.o`\"=._``  '` \" ,__.--o;   |\r\n"
	            + "|___________________|_| ;     (#) `-.o `\"=.`_.--\"_o.-; ;___|___________________\r\n"
	            + "____/______/______/___|o;._    \"      `\".o|o_.--\"    ;o;____/______/______/____\r\n"
	            + "/______/______/______/_\"=._o--._        ; | ;        ; ;/______/______/______/_\r\n"
	            + "____/______/______/______/__\"=._o--._   ;o|o;     _._;o;____/______/______/____\r\n"
	            + "/______/______/______/______/____\"=._o._; | ;_.--\"o.--\"_/______/______/______/_\r\n"
	            + "____/______/______/______/______/_____\"=.o|o_.--\"\"___/______/______/______/____\r\n"
	            + "/______/______/______/______/______/______/______/______/______/______/_______/\r\n"
	            + "*******************************************************************************";
	}
	
}