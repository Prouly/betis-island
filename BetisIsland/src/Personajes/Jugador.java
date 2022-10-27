package Personajes;
import Juego.*;

public class Jugador extends Personaje{
	boolean tieneEspada;
	boolean tienePala;
	
	public Jugador(String nombre) {
		super(100, nombre);
		setPosicionX(0);
		setPosicionY(0);
		tieneEspada = false;
		tienePala = false;
	}

    public int getPosicionY() {
		return posicionY;
	}

	public int getPosicionX() {
		return posicionX;
	}
	
	@Override
	public int getVida() {
		return super.getVida();
	}

	/**
	 * Ajusta la posicion X del jugador
	 * @param posicionX
	 */
	public void setPosicionX(int posicionX){
		if (posicionX >= APrincipal.TAMANHO_MAPA || posicionX < 0) {
			System.out.println("No puedes pasar por ahi");
			System.out.println();
		}else {
		    this.posicionX = posicionX;
		}
	}
	
	/**
	 * Ajusta la posicion Y del jugador
	 * @param posicionY
	 */
	public void setPosicionY(int posicionY){
		if (posicionY >= APrincipal.TAMANHO_MAPA || posicionY < 0) {
			System.out.println("No puedes pasar por ahi");
			System.out.println();
		}else {
		    this.posicionY = posicionY;
		}
	}
	
	@Override
	public void setVida(int vida) {
		// TODO Auto-generated method stub
		super.setVida(vida);
	}
	
   public boolean isTieneEspada() {
        return tieneEspada;
    }


    public boolean isTienePala() {
        return tienePala;
    }

    //Metodos para cambiar los objetos que tiene
    public void conseguirPala() {
        this.tienePala = true;
    }
	
    public void conseguirEspada() {
        this.tieneEspada = true;
    }
	
	@Override
	public String toString() {
		String objetosEncontrados = null;
		if (tieneEspada) {
		    objetosEncontrados = "Espada";
		}
		if (tienePala) {
		    objetosEncontrados = "Pala";
		}
		
		if (tieneEspada && tienePala) {
		    objetosEncontrados = "Espada y Pala";
		}
		
		if (!tieneEspada && !tienePala) {
		    objetosEncontrados = "Ninguno";
		}
		return(
		          " ,~~.   \n"
		        + " :'':     -- " + nombre +" --\n"   
		        + " ,`'.     Vida: " + vida + "\n"
		        + "/|__|\\    Posicion: " + posicionX + ", " + posicionY + "\n"
		        + "`|::|'    Objetos: " + objetosEncontrados + "\n"
		        + " |/\\|\r\n"
		        + ".:  :.");
	}//toString
	
}