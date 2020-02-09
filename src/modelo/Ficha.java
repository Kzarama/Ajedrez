package modelo;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class Ficha {
	/**
	 * atributos de la clase Ficha
	 */
	private int posicionX;
	private int posicionY;
	private String color;
	private String tipo;
	private int numeroMovimientos;
	/**
	 * constructor de la clase Ficha
	 * @param posicionX
	 * @param posicionY
	 * @param color
	 * @param tipo
	 */
	public Ficha(int posicionX, int posicionY, String color, String tipo) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.color = color;
		this.tipo = tipo;
		numeroMovimientos = 0;
	}
	/**
	 * getPosicionX
	 * @return posicionX
	 */
	public int getPosicionX() {
		return posicionX;
	}
	/**
	 * setPosicionX
	 * @param posicionX
	 */
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	/**
	 * getPosicionY
	 * @return posicionY
	 */
	public int getPosicionY() {
		return posicionY;
	}
	/**
	 * setPosicionY
	 * @param posicionY
	 */
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	/**
	 * getColor
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * setColor
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * getTipo
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * setTipo
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * getNumeroMovimientos
	 * @return NumeroMovimientos
	 */
	public int getNumeroMovimientos() {
		return numeroMovimientos;
	}
	/**
	 * setNumeroMovimientos
	 * @param numeroMovimientos
	 */
	public void setNumeroMovimientos(int numeroMovimientos) {
		this.numeroMovimientos = numeroMovimientos;
	}
}
