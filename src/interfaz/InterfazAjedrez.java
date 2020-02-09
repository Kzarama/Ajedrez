package interfaz;
import java.awt.*;
import javax.swing.*;

import excepciones.MovimientoInvalidoException;
import modelo.Ficha;
import modelo.Tablero;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class InterfazAjedrez extends JFrame{
	/**
	 * atributos de la clase InterfazAjedrez
	 */
	private PanelTablero panTablero;
	private PanelOpciones panOpciones;
	private Tablero tablero;
	/**
	 * constructor de la clase
	 */
	public InterfazAjedrez() {
		mensaje();
		tablero = new Tablero();
		panTablero = new PanelTablero(this);
		panOpciones = new PanelOpciones(this);
		setSize(400, 400);
		setTitle("AJEDREZ");
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(panTablero, BorderLayout.CENTER);
		add(panOpciones, BorderLayout.EAST);
		pack();
	}
	/**
	 * mensaje
	 */
	public void mensaje() {
		JOptionPane.showMessageDialog(null, "BIENVENIDO A JUGAR AJEDREZ\ningrese las coordenadas asi: primero la letra de la ficha de inicio, luego el numero de la\nficha de inicio, despues la letra de la casilla final y por ultimo el numero de la casilla final (A1A1)\npresione aceptar para continuar");
		JOptionPane.showMessageDialog(null, "TURNO DE LAS FICHAS BLANCAS\npresione aceptar para continuar");
	}
	/**
	 * rotarTablero
	 */
	public void rotarTablero() {
		tablero.rotarTablero();
		panTablero.crearTablero();
	}
	/**
	 * darColorCasilla
	 * @return arreglo String color de las casillas
	 */
	public String[][] darColorCasilla() {
		return tablero.getColorCasillas();
	}
	/**
	 * darFichas
	 * @return arreglo con la clase Ficha
	 */
	public Ficha[][] darFichas(){
		return tablero.getFichas();
	}
	/**
	 * mover
	 * @param movi
	 * @throws MovimientoInvalidoException 
	 */
	public void mover(String movimientos) throws Exception {
		try {
			tablero.darMovimientos(movimientos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "COORDENADAS INCORRECTAS\npresione aceptar para volver a intentar", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		panTablero.crearTablero();
		rotarTableroTurnos();
	}
	/**
	 * rotarTableroTurnos()
	 */
	public void rotarTableroTurnos() {
		if(tablero.getAmovido()) {
			if(getBooleanTurno()) {
				panOpciones.rotar();
				panOpciones.rotar();
				JOptionPane.showMessageDialog(null, "TURNO DE LAS FICHAS BLANCAS\npresione aceptar para continuar");
			}else if(!getBooleanTurno()) {
				panOpciones.rotar();
				panOpciones.rotar();
				JOptionPane.showMessageDialog(null, "TURNO DE LAS FICHAS NEGRAS\npresione aceptar para continuar");
			}
		}
	}
	/**
	 * getBooleanTurno()
	 * @return BooleanTurno
	 */
	public boolean getBooleanTurno() {
		return tablero.getBooleanTurno();
	}
	/**
	 * setCoordenadas
	 * @param f
	 * @param c
	 */
	public void setCoordenadas(int f, int c) {
		panOpciones.setCoordenadas(f, c);
	}
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		InterfazAjedrez inter = new InterfazAjedrez();
		inter.setVisible(true);
	}
}