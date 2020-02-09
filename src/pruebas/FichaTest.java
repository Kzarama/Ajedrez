package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import modelo.Ficha;

public class FichaTest extends TestCase {
	Ficha ficha;
	private void escenario1() {
		ficha = new Ficha(0, 0, "B","P");
	}
	private void escenario2() {
		ficha = new Ficha(0, 0, "B","P");
	}
	private void escenario3() {
		ficha = new Ficha(0, 0, "B","P");
	}
	private void escenario4() {
		ficha = new Ficha(0, 0, "B","P");
	}
	private void escenario5() {
		ficha = new Ficha(0, 0, "B","P");
	}
	@Test
	public void testGetTipo() {
		escenario1();
		assertEquals("P", ficha.getTipo());
	}
	@Test
	public void testGetColor() {
		escenario2();
		assertEquals("B", ficha.getColor());
	}
	@Test
	public void testGetPosicionX() {
		escenario3();
		assertEquals(0, ficha.getPosicionX());
	}
	@Test
	public void testGetPosicionY() {
		escenario4();
		assertEquals(0, ficha.getPosicionY());
	}
	@Test
	public void testGetNumeroMovimientos() {
		escenario5();
		assertEquals(0, ficha.getNumeroMovimientos());
	}
}