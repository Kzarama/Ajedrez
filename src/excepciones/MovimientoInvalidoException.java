package excepciones;
public class MovimientoInvalidoException extends Exception {
	public MovimientoInvalidoException(){
		super("Movimiento inv�lido, vuelva a repetir la jugada");
	}
}