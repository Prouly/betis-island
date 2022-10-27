package Personajes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Insultos {
	
	public static String[] cargarInsultos() throws FileNotFoundException, IOException{
		//Cuenta el numero de lineas
		BufferedReader bf = new BufferedReader(new FileReader("insultos.txt"));
		int contador = 0;
		String linea = bf.readLine();
		while (linea != null) {
			contador++;
			linea = bf.readLine();
		}
		bf.close();
		
		//Crea un array
		String[] arrayInsultos = new String[contador];
		
		//Llena el array
		BufferedReader bf2 = new BufferedReader(new FileReader("insultos.txt"));
		for (int i = 0; i < arrayInsultos.length; i++) {
			arrayInsultos[i]  = bf2.readLine();
		}
		bf2.close();
		
		return arrayInsultos;
	}//cargarInsultos()
	
	public static String[] elegirAleatorios() throws FileNotFoundException, IOException{
		String[] arrayInsultos = cargarInsultos();
		Random rnd = new Random();
		String[] insultosAleatorios = new String[3];
		
		for (int i = 0; i < 3; i++) {
			//Llena el array de aleatorios con un insulto del arrayInsultos aleatorio (random desde 0 hasta length excluyente)
			insultosAleatorios[i] = arrayInsultos[rnd.nextInt(arrayInsultos.length)];
		}
		
		//Probar si funciona
//		for (int i = 0; i < insultosAleatorios.length; i++) {
//			System.out.println(insultosAleatorios[i]);
//		}

		return insultosAleatorios;

	}//elegirAleatorios()
	
}
