package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class PanelTablero extends JPanel implements ActionListener{
	/**
	 * atributos de la clase
	 */ 
	private ImageIcon torre_negra, torre_blanca, caballo_negro, caballo_blanco, alfil_negro, alfil_blanco, dama_negra, dama_blanca, rey_negro, rey_blanco, peon_negro, peon_blanco;
	private JButton[][] botones;
	private String[][] botonesString;
	private JLabel[] numeros, letras;
	private JPanel tablero, panelNumeros, panelLetras;
	private InterfazAjedrez interfaz;
	private boolean mover = true;
	/**
	 * constructor de la clase PanelTablero
	 * @param interfaz
	 */
	public PanelTablero(InterfazAjedrez interfaz) {
		setLayout(new BorderLayout());
		this.interfaz = interfaz;
		torre_negra = new ImageIcon("img/torre_negra.png");
		torre_blanca = new ImageIcon("img/torre_blanca.png");
		caballo_negro = new ImageIcon("img/caballo_negro.png");
		caballo_blanco = new ImageIcon("img/caballo_blanco.png");
		alfil_negro = new ImageIcon("img/alfil_negro.png");
		alfil_blanco = new ImageIcon("img/alfil_blanco.png");
		dama_negra = new ImageIcon("img/dama_negra.png");
		dama_blanca = new ImageIcon("img/dama_blanca.png");
		rey_negro = new ImageIcon("img/rey_negro.png");
		rey_blanco = new ImageIcon("img/rey_blanco.png");
		peon_negro = new ImageIcon("img/peon_negro.png");
		peon_blanco = new ImageIcon("img/peon_blanco.png");
		tablero = new JPanel(new GridLayout(8, 8));
		botonesString = new String[8][8];
		botones = new JButton[8][8];
		for(int f = 0; f < 8; f++) {
			for(int c = 0; c < 8; c++) {
				botonesString[f][c] = f+""+c;

			}
		}
		panelNumeros = new JPanel(new GridLayout(8, 1));
		panelLetras = new JPanel(new GridLayout(1, 8));
		numeros = new JLabel[8];
		letras = new JLabel[8];
		crearLetras();
		crearNumeros();
		crearTablero();
	}
	/**
	 * crearNumeros
	 */
	public void crearNumeros() {
		for (int i = 7; i > -1; i--) {
			numeros[i] = new JLabel("<html><div style='font-size:20px;'>"+(1+i) +"</div></html>",SwingConstants.CENTER);
			panelNumeros.add(numeros[i]);
		}
	}
	/**
	 * crearLetras
	 */
	public void crearLetras() {
		for (int k = 0; k < 8; k++) {
			char le = (char) k;
			le += 65;
			letras[k] = new JLabel("<html><div style='font-size:20px;'>"+le + "</div></html>",SwingConstants.CENTER);
			panelLetras.add(letras[k]);
		}
	}
	/**
	 * crearTablero
	 */
	public void crearTablero() {
		removeAll();
		repaint();
		tablero = new JPanel(new GridLayout(8, 8));
		for (int f = 0; f < 8; f++) {
			for (int c = 0; c < 8; c++) {
				botones[f][c] = new JButton();
				botones[f][c].setActionCommand(botonesString[f][c]);
				botones[f][c].addActionListener(this);
				if (interfaz.darColorCasilla()[f][c] == "B") {
					botones[f][c].setBackground(Color.WHITE);
				} else if (interfaz.darColorCasilla()[f][c] == "N"){
					botones[f][c].setBackground(Color.DARK_GRAY);
				}
				if (interfaz.darFichas()[f][c].getTipo().equals("T") && interfaz.darFichas()[f][c].getColor().equals("B")) {
					botones[f][c].setIcon(torre_blanca);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("T") &&  interfaz.darFichas()[f][c].getColor().equals("N")) {
					botones[f][c].setIcon(torre_negra);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("C") &&  interfaz.darFichas()[f][c].getColor().equals("B")) {
					botones[f][c].setIcon(caballo_blanco);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("C") &&  interfaz.darFichas()[f][c].getColor().equals("N")) {
					botones[f][c].setIcon(caballo_negro);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("A") &&  interfaz.darFichas()[f][c].getColor().equals("B")) {
					botones[f][c].setIcon(alfil_blanco);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("A") &&  interfaz.darFichas()[f][c].getColor().equals("N")) {
					botones[f][c].setIcon(alfil_negro);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("R") &&  interfaz.darFichas()[f][c].getColor().equals("B")) {
					botones[f][c].setIcon(dama_blanca);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("R") &&  interfaz.darFichas()[f][c].getColor().equals("N")) {
					botones[f][c].setIcon(dama_negra);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("E") &&  interfaz.darFichas()[f][c].getColor().equals("B")) {
					botones[f][c].setIcon(rey_blanco);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("E") &&  interfaz.darFichas()[f][c].getColor().equals("N")) {
					botones[f][c].setIcon(rey_negro);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("P") &&  interfaz.darFichas()[f][c].getColor().equals("B")) {
					botones[f][c].setIcon(peon_blanco);
				} else if (interfaz.darFichas()[f][c].getTipo().equals("P") &&  interfaz.darFichas()[f][c].getColor().equals("N")) {
					botones[f][c].setIcon(peon_negro);
				}
			tablero.add(botones[f][c]);
			}
		}
		if (mover == true) {
			add(panelLetras, BorderLayout.SOUTH);
			add(panelNumeros, BorderLayout.WEST);
		}
		add(tablero, BorderLayout.CENTER);
	}
	/**
	 * cambiarColorCasillas
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillas(int f, int c) {
		repaint();
		if(interfaz.getBooleanTurno() && interfaz.darFichas()[f][c].getColor() == "B") {
			if(interfaz.darFichas()[f][c].getTipo().equals("P")){
				cambiarColorCasillaPeon(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("C")){
				cambiarColorCasillaCaballo(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("E")){
				cambiarColorCasillaRey(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("T")){
				cambiarColorCasillaTorre(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("A")){
				cambiarColorCasillaAlfil(f, c);
			}else {
				cambiarColorCasillaReina(f, c);
			}
		} else if(!interfaz.getBooleanTurno() && interfaz.darFichas()[f][c].getColor() == "N"){
			if(interfaz.darFichas()[f][c].getTipo().equals("P")){
				cambiarColorCasillaPeon(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("C")){
				cambiarColorCasillaCaballo(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("E")){
				cambiarColorCasillaRey(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("T")){
				cambiarColorCasillaTorre(f, c);
			}else if(interfaz.darFichas()[f][c].getTipo().equals("A")){
				cambiarColorCasillaAlfil(f, c);
			}else {
				cambiarColorCasillaReina(f, c);
			}
		}
	}
	/**
	 * cambiarColorCasillaPeon
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillaPeon(int f, int c){
		botones[f][c].setBackground(Color.CYAN);
		if(f-1 >= 0) {
			if(interfaz.darFichas()[f][c].getNumeroMovimientos() == 0 && interfaz.darFichas()[f-1][c].getTipo() == "") {
				botones[f-1][c].setBackground(Color.BLUE);
			}else if(interfaz.darFichas()[f][c].getNumeroMovimientos() > 0 && interfaz.darFichas()[f-1][c].getTipo() == ""){
				botones[f-1][c].setBackground(Color.BLUE);
			}
		}
		if(interfaz.darFichas()[f][c].getNumeroMovimientos() == 0 && interfaz.darFichas()[f-2][c].getTipo() == ""){
			botones[f-2][c].setBackground(Color.BLUE);
		}
		if((f-1 >= 0 && c-1 >= 0) && (f-1 <= 7 && c-1 <= 7)) {
			if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f-1][c-1].getColor() && interfaz.darFichas()[f-1][c-1].getColor() != "") {
				botones[f-1][c-1].setBackground(Color.RED);
			}
		}
		if((f-1 >= 0 && c+1 >= 0) && (f-1 <= 7 && c+1 <= 7)) {
			if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f-1][c+1].getColor() && interfaz.darFichas()[f-1][c+1].getColor() != "") {
				botones[f-1][c+1].setBackground(Color.RED);
			}
		}
	}
	/**
	 * cambiarColorCasillaCaballo
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillaCaballo(int f, int c) {
		botones[f][c].setBackground(Color.CYAN);
		if((f-2 >= 0 && c+1 <= 7) && (interfaz.darFichas()[f-2][c+1].getColor() == "")){
			botones[f-2][c+1].setBackground(Color.BLUE);
		}else if((f-2 >= 0 && c+1 <= 7) && interfaz.darFichas()[f-2][c+1].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f-2][c+1].setBackground(Color.RED);
		}
		if((f-1 >= 0 && c+2 <= 7) && (interfaz.darFichas()[f-1][c+2].getColor() == "")){
			botones[f-1][c+2].setBackground(Color.BLUE);
		}else if((f-1 >= 0 && c+2 <= 7) && interfaz.darFichas()[f-1][c+2].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f-1][c+2].setBackground(Color.RED);
		}
		if((f+2 <= 7 && c-1 >= 0) && (interfaz.darFichas()[f+2][c-1].getColor() == "")) {
			botones[f+2][c-1].setBackground(Color.BLUE);
		}else if((f+2 <= 7 && c-1 >= 0) && interfaz.darFichas()[f+2][c-1].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f+2][c-1].setBackground(Color.RED);
		}
		if((f+1 <= 7 && c-2 >= 0) && (interfaz.darFichas()[f+1][c-2].getColor() == "")) {
			botones[f+1][c-2].setBackground(Color.BLUE);
		}else if((f+1 <= 7 && c-2 >= 0) && interfaz.darFichas()[f+1][c-2].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f+1][c-2].setBackground(Color.RED);
		}
		if((f-1 >= 0 && c-2 >= 0) && (interfaz.darFichas()[f-1][c-2].getColor() == "")) {
			botones[f-1][c-2].setBackground(Color.BLUE);
		}else if((f-1 >= 0 && c-2 >= 0) && interfaz.darFichas()[f-1][c-2].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f-1][c-2].setBackground(Color.RED);
		}
		if((f-2 >= 0 && c-1 >= 0) && (interfaz.darFichas()[f-2][c-1].getColor() == "")) {
			botones[f-2][c-1].setBackground(Color.BLUE);
		}else if((f-2 >= 0 && c-1 >= 0) && interfaz.darFichas()[f-2][c-1].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f-2][c-1].setBackground(Color.RED);
		}
		if((f+2 <= 7 && c+1 <= 7) && (interfaz.darFichas()[f+2][c+1].getColor() == "")) {
			botones[f+2][c+1].setBackground(Color.BLUE);
		}else if((f+2 <= 7 && c+1 <= 7) && interfaz.darFichas()[f+2][c+1].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f+2][c+1].setBackground(Color.RED);
		}
		if((f+2 <= 7 && c+1 <= 7) && (interfaz.darFichas()[f+1][c+2].getColor() == "")) {
			botones[f+1][c+2].setBackground(Color.BLUE);
		}else if((f+2 <= 7 && c+1 <= 7) && interfaz.darFichas()[f+1][c+2].getColor() != interfaz.darFichas()[f][c].getColor()){
			botones[f+1][c+2].setBackground(Color.RED);
		}
	}
	/**
	 * cambiarColorCasillaRey
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillaRey(int f, int c) {
		botones[f][c].setBackground(Color.CYAN);
		if(f-1 >= 0 && interfaz.darFichas()[f-1][c].getColor() == "") {
			botones[f-1][c].setBackground(Color.BLUE);
		}else if(f-1 >= 0 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f-1][c].getColor()) {
			botones[f-1][c].setBackground(Color.RED);
		}
		if(c-1 >= 0 && interfaz.darFichas()[f][c-1].getColor() == "") {
			botones[f][c-1].setBackground(Color.BLUE);
		}else if(c-1 >= 0 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f][c-1].getColor()) {
			botones[f][c-1].setBackground(Color.RED);
		}
		if(f+1 <= 7 && interfaz.darFichas()[f+1][c].getColor() == "") {
			botones[f+1][c].setBackground(Color.BLUE);
		}else if(f+1 <= 7 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f+1][c].getColor()) {
			botones[f+1][c].setBackground(Color.RED);
		}
		if(c+1 >= 0 && interfaz.darFichas()[f][c+1].getColor() == "") {
			botones[f][c+1].setBackground(Color.BLUE);
		}else if(c+1 >= 0 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f][c+1].getColor()) {
			botones[f][c+1].setBackground(Color.RED);
		}
		if(f+1 <= 7 && c+1 <= 7 && interfaz.darFichas()[f+1][c+1].getColor() == "") {
			botones[f+1][c+1].setBackground(Color.BLUE);
		}else if(f+1 <= 7 && c+1 <= 7 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f+1][c+1].getColor()) {
			botones[f+1][c+1].setBackground(Color.RED);
		}
		if(f+1 <= 7 && c-1 >= 0 && interfaz.darFichas()[f+1][c-1].getColor() == "") {
			botones[f+1][c-1].setBackground(Color.BLUE);
		}else if(f+1 <= 7 && c-1 >= 0 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f+1][c-1].getColor()) {
			botones[f+1][c-1].setBackground(Color.RED);
		}
		if(f-1 >= 0 && c+1 <= 7 && interfaz.darFichas()[f-1][c+1].getColor() == "") {
			botones[f-1][c+1].setBackground(Color.BLUE);
		}else if(f-1 >= 0 && c+1 <= 7 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f-1][c+1].getColor()) {
			botones[f-1][c+1].setBackground(Color.RED);
		}
		if(f-1 >= 0 && c-1 >= 0 && interfaz.darFichas()[f-1][c-1].getColor() == "") {
			botones[f-1][c-1].setBackground(Color.BLUE);
		}else if(f-1 >= 0 && c-1 >= 0 && interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f-1][c-1].getColor()) {
			botones[f-1][c-1].setBackground(Color.RED);
		}
	}
	/**
	 * cambiarColorCasillaTorre	
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillaTorre(int f, int c) {
		botones[f][c].setBackground(Color.CYAN);
		boolean torrePasar = true;
		for(int numeroFinal = f-1; numeroFinal >= 0 && torrePasar; numeroFinal--) {
			if(interfaz.darFichas()[numeroFinal][c].getColor() == "") {
				botones[numeroFinal][c].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][c].getColor()) {
				botones[numeroFinal][c].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		torrePasar = true;
		for(int numeroFinal = f+1; numeroFinal <= 7 && torrePasar; numeroFinal++) {
			if(interfaz.darFichas()[numeroFinal][c].getColor() == "") {
				botones[numeroFinal][c].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][c].getColor()) {
				botones[numeroFinal][c].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		torrePasar = true;
		for(int letraFinal = c-1; letraFinal >=0 && torrePasar; letraFinal--) {
			if(interfaz.darFichas()[f][letraFinal].getColor() == "") {
				botones[f][letraFinal].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f][letraFinal].getColor()) {
				botones[f][letraFinal].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		torrePasar = true;
		for(int letraFinal = c+1; letraFinal <=7 && torrePasar; letraFinal++) {
			if(interfaz.darFichas()[f][letraFinal].getColor() == "") {
				botones[f][letraFinal].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f][letraFinal].getColor()) {
				botones[f][letraFinal].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
	}
	/**
	 * cambiarColorCasillaAlfil
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillaAlfil(int f, int c) {
		botones[f][c].setBackground(Color.CYAN);
		boolean variable = true;
		for(int numeroFinal = f-1; numeroFinal >= 0 && variable; numeroFinal--) {
			for(int letraFinal = c-1; letraFinal >= 0 && variable; letraFinal--) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						variable = true;
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
					}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					}else{
						variable = false;
					}
				}
			}
		}
		variable = true;
		for(int numeroFinal = f+1; numeroFinal <= 7 && variable; numeroFinal++) {
			for(int letraFinal = c-1; letraFinal >= 0 && variable; letraFinal--) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
						variable = true;
					} else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					} else {
						variable = false;
					}
				}
			}
		}
		variable = true;
		for(int numeroFinal = f-1; numeroFinal >= 0 && variable; numeroFinal--) {
			for(int letraFinal = c+1; letraFinal <= 7 && variable; letraFinal++) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						variable = true;
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
					}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					} else {
						variable = false;
					}
				}
			}
		}
		variable = true;
		for(int numeroFinal = f+1; numeroFinal <= 7 && variable; numeroFinal++) {
			for(int letraFinal = c+1; letraFinal <= 7 && variable; letraFinal++) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
						variable = true;
					}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					} else {
						variable = false;
					}
				}
			}
		}
	}
	/**
	 * cambiarColorCasillaReina
	 * @param f
	 * @param c
	 */
	public void cambiarColorCasillaReina(int f, int c) {
		botones[f][c].setBackground(Color.CYAN);
		boolean torrePasar = true;
		for(int numeroFinal = f-1; numeroFinal >= 0 && torrePasar; numeroFinal--) {
			if(interfaz.darFichas()[numeroFinal][c].getColor() == "") {
				botones[numeroFinal][c].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][c].getColor()) {
				botones[numeroFinal][c].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		torrePasar = true;
		for(int numeroFinal = f+1; numeroFinal <= 7 && torrePasar; numeroFinal++) {
			if(interfaz.darFichas()[numeroFinal][c].getColor() == "") {
				botones[numeroFinal][c].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][c].getColor()) {
				botones[numeroFinal][c].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		torrePasar = true;
		for(int letraFinal = c-1; letraFinal >=0 && torrePasar; letraFinal--) {
			if(interfaz.darFichas()[f][letraFinal].getColor() == "") {
				botones[f][letraFinal].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f][letraFinal].getColor()) {
				botones[f][letraFinal].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		torrePasar = true;
		for(int letraFinal = c+1; letraFinal <=7 && torrePasar; letraFinal++) {
			if(interfaz.darFichas()[f][letraFinal].getColor() == "") {
				botones[f][letraFinal].setBackground(Color.BLUE);
				torrePasar = true;
			}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[f][letraFinal].getColor()) {
				botones[f][letraFinal].setBackground(Color.RED);
				torrePasar = false;
			}else {
				torrePasar = false;
			}
		}
		boolean variable = true;
		for(int numeroFinal = f-1; numeroFinal >= 0 && variable; numeroFinal--) {
			for(int letraFinal = c-1; letraFinal >= 0 && variable; letraFinal--) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						variable = true;
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
					}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					}else{
						variable = false;
					}
				}
			}
		}
		variable = true;
		for(int numeroFinal = f+1; numeroFinal <= 7 && variable; numeroFinal++) {
			for(int letraFinal = c-1; letraFinal >= 0 && variable; letraFinal--) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
						variable = true;
					} else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					} else {
						variable = false;
					}
				}
			}
		}
		variable = true;
		for(int numeroFinal = f-1; numeroFinal >= 0 && variable; numeroFinal--) {
			for(int letraFinal = c+1; letraFinal <= 7 && variable; letraFinal++) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						variable = true;
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
					}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					} else {
						variable = false;
					}
				}
			}
		}
		variable = true;
		for(int numeroFinal = f+1; numeroFinal <= 7 && variable; numeroFinal++) {
			for(int letraFinal = c+1; letraFinal <= 7 && variable; letraFinal++) {
				if((Math.abs(f-numeroFinal) == Math.abs(c-letraFinal))) {
					if(interfaz.darFichas()[numeroFinal][letraFinal].getColor() == "") {
						botones[numeroFinal][letraFinal].setBackground(Color.BLUE);
						variable = true;
					}else if(interfaz.darFichas()[f][c].getColor() != interfaz.darFichas()[numeroFinal][letraFinal].getColor()) {
						botones[numeroFinal][letraFinal].setBackground(Color.RED);
						variable = false;
					} else {
						variable = false;
					}
				}
			}
		}
	}
	/**
	 * actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		for (int f = 0; f < 8; f++) {
			for (int c = 0; c < 8; c++) {
				if(comando.equals(botonesString[f][c])) {
					crearTablero();
					cambiarColorCasillas(f, c);
					interfaz.setCoordenadas(f, c);
					interfaz.setExtendedState(interfaz.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					interfaz.setExtendedState(JFrame.NORMAL);
				}
			}
		}
	}
}