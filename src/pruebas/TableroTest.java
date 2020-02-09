package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import excepciones.MovimientoInvalidoException;
import junit.framework.TestCase;
import modelo.Ficha;
import modelo.Tablero;

public class TableroTest extends TestCase{
	Tablero t;
	private void escenario1() {
		t = new Tablero();
	}
	private void escenario2() {
		t = new Tablero();
	}
	private void escenario3() {
		t = new Tablero();
	}
	private void escenario4() {
		t = new Tablero();
	}
	private void escenario5() {
		t = new Tablero();
	}
	private void escenario6() {
		t = new Tablero();
	}
	private void escenario7() {
		t = new Tablero();
	}
	private void escenario8() {
		t = new Tablero();
	}
	@Test
	public void testGetBooleanTurno() {
		escenario1();
		assertTrue(t.getBooleanTurno());
	}
	@Test
	public void testCrearTablero() {
		escenario2();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		for (int f = 0; f < 8; f++) {
			for (int c = 0; c < 8; c++) {
				String cadenaFichas = "TCAREACT";
				if (f == 0) {
					String a = cadenaFichas.charAt(c) + "";
					matriz[f][c] = new Ficha(f, c, "N", a);
				}else if(f == 1) {
					matriz[f][c] = new Ficha(f, c, "N", "P");
				}else if(f == 6) {
					matriz[f][c] = new Ficha(f, c, "B", "P");
				}else if(f == 7) {
					String a = cadenaFichas.charAt(c) + "";
					matriz[f][c] = new Ficha(f, c, "B", a);
				}else {
					matriz[f][c] = new Ficha(f, c, "", "");
				}
			}
		}
		t.crearMatriz();
		assertEquals(matriz.getClass(), t.getFichas().getClass());
	}
	@Test
	public void testMoverPeon() throws MovimientoInvalidoException {
		escenario3();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		matriz[4][0] = new Ficha(4, 0, "B", "P");
		t.moverPeon(6, 0, 4, 0);
		assertEquals(matriz[4][0].getTipo(), t.getFichas()[4][0].getTipo());
	}
	@Test
	public void testMoverCaballo() throws MovimientoInvalidoException {
		escenario4();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		matriz[5][2] = new Ficha(5, 2, "B", "C");
		t.moverCaballo(7, 1, 5, 2);
		assertEquals(matriz[5][2].getTipo(), t.getFichas()[5][2].getTipo());
	}
	@Test
	public void testMoverAlfil() throws MovimientoInvalidoException {
		escenario5();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		matriz[2][7] = new Ficha(2, 7, "B", "A");
		t.moverAlfil(7, 2, 2, 7);
		assertEquals(matriz[2][7].getTipo(), t.getFichas()[2][7].getTipo());
	}
	@Test
	public void testMoverTorre() throws MovimientoInvalidoException {
		escenario6();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		matriz[5][0] = new Ficha(5, 0, "B", "T");
		t.moverPeon(6, 0, 4, 0);
		t.moverTorre(7, 0, 5, 0);
		assertEquals(matriz[5][0].getTipo(), t.getFichas()[5][0].getTipo());
	}
	@Test
	public void testMoverRey() throws MovimientoInvalidoException {
		escenario7();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		matriz[6][4] = new Ficha(6, 4, "B", "E");
		t.moverPeon(6, 4, 5, 4);
		t.moverRey(7, 4, 6, 4);
		assertEquals(matriz[6][4].getTipo(), t.getFichas()[6][4].getTipo());
	}
	@Test
	public void testMoverReina() throws MovimientoInvalidoException {
		escenario8();
		Ficha[][] matriz;
		matriz = new Ficha[8][8];
		matriz[3][7] = new Ficha(3, 7, "B", "R");
		t.moverPeon(6, 0, 4, 0);
		t.moverReina(7, 3, 3, 7);
		assertEquals(matriz[3][7].getTipo(), t.getFichas()[3][7].getTipo());
	}
}