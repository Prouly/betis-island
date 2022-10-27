package Personajes;

public abstract class Personaje {
	
	int vida;
	String nombre;

	int posicionX;
	int posicionY;
	
	public Personaje(int vida, String nombre) {
		this.vida = vida;
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
