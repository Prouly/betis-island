package Personajes;
import Juego.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class NPC extends Personaje{

	
	public NPC() throws IOException, FileNotFoundException{
		super(10, elegirNombreAleatorio());
		setPosicionX();
		setPosicionY();
	}
	
	/**
	 * Elige un nombre aleatorio del txt para ponerselo al enemigo
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String elegirNombreAleatorio() throws FileNotFoundException, IOException{
		//Cuenta el numero de lineas
		BufferedReader bf = new BufferedReader(new FileReader("NombresPiratas.txt"));
		int contador = 0;
		String linea = bf.readLine();
		while (linea != null) {
			contador++;
			linea = bf.readLine();
		}
		bf.close();
		
		//Crea un array
		String[] arrayNombres = new String[contador];
		
		//Llena el array
		BufferedReader bf2 = new BufferedReader(new FileReader("NombresPiratas.txt"));
		for (int i = 0; i < arrayNombres.length; i++) {
			arrayNombres[i]  = bf2.readLine();
		}
		bf2.close();
		
		//Elige un nombre de la lista
		Random rnd = new Random();
		
		return arrayNombres[rnd.nextInt(arrayNombres.length)];
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionX() {
		this.posicionX = new Random().nextInt(APrincipal.TAMANHO_MAPA);
	}


	public void setPosicionY() {
		this.posicionY = new Random().nextInt(APrincipal.TAMANHO_MAPA);
	}

	@Override
	public String toString() {
		return "NPC [nombre=" + nombre + ", posicionX=" + posicionX + ", posicionY=" + posicionY + "]";
	}

	
	
}
