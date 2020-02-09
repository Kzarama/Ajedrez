package excepciones;
public class MovimientoInvalidoException extends Exception {
	public MovimientoInvalidoException(){
		super("Movimiento inválido, vuelva a repetir la jugada");
	}
}