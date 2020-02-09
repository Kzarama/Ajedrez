package modelo;
import excepciones.MovimientoInvalidoException;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class Tablero {
	/**
	 * atributos de la clase Tablero
	 */
	private Ficha[][] fichas;
	private String[][] colorCasilla;
	int a = 0;
	private int numeroTurno;
	private boolean amovido;
	/**
	 * constructor de la clase tablero
	 */
	public Tablero() {
		amovido = false;
		numeroTurno = 0;
		colorCasilla = new String[8][8];
		fichas = new Ficha[8][8];
		crearMatriz();
	}
	public void setMatriz(Ficha[][] matriz) {
		fichas = matriz;
	}
	/**
	 * crearMatriz
	 */
	public void crearMatriz() {
		for (int f = 0; f < 8; f++) {
			for (int c = 0; c < 8; c++) {
				String cadenaFichas = "TCAREACT";
				if (f == 0) {
					String a = cadenaFichas.charAt(c) + "";
					fichas[f][c] = new Ficha(f, c, "N", a);
				}else if(f == 1) {
					fichas[f][c] = new Ficha(f, c, "N", "P");
				}else if(f == 6) {
					fichas[f][c] = new Ficha(f, c, "B", "P");
				}else if(f == 7) {
					String a = cadenaFichas.charAt(c) + "";
					fichas[f][c] = new Ficha(f, c, "B", a);
				}else {
					fichas[f][c] = new Ficha(f, c, "", "");
				}
				if ((( f + c ) % 2) == 0) {
					colorCasilla[f][c] = "B";
						}else {
					colorCasilla[f][c] = "N";
				}
			}
		}
	}
	/**
	 * rotarTablero
	 */
	public void rotarTablero() {
		Ficha[][] matriz = new Ficha[8][8];
		for (int f = 0; f < 8; f++) {
			int k = 7;
			for (int c = 0; c < 8; c++) {
				matriz[c][f] = fichas[f][k];				
				k--;
			}
		}
		for (int f = 0; f < 8; f++) {
			for (int c = 0; c < 8; c++) {
				fichas[c][f] = matriz[c][f];
			}
		}
		
		if((a % 2) == 0) {
			for (int f = 0; f < 8; f++) {
				for (int c = 0; c < 8; c++) {
					if ((( f + c ) % 2) == 0) {
						colorCasilla[f][c] = "N";
					}else {
						colorCasilla[f][c] = "B";		
					}
				}
			}
			a++;
		} else {
			for (int f = 0; f < 8; f++) {
				for (int c = 0; c < 8; c++) {
					if ((( f + c ) % 2) == 0) {
						colorCasilla[f][c] = "B";
					}else {
						colorCasilla[f][c] = "N";
					}
				}
			}
			a++;
		}
	}
	/**
	 * setFichas
	 * @param fichas
	 */
	public void setFichas(Ficha[][] fichas) {
		this.fichas = fichas;
	}
	/**
	 * getFichas
	 * @return fichas
	 */
	public Ficha[][] getFichas() {
		return fichas;
	}
	/**
	 * getColorCasillas
	 * @return colorCasilla
	 */
	public String[][] getColorCasillas() {
		return colorCasilla;
	}
	/**
	 * darMovimientos
	 * @param movimientos
	 * @throws MovimientoInvalidoException
	 */
	public void darMovimientos(String movimientos) throws MovimientoInvalidoException {
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 3;
		if(movimientos.length() == 5) {
			a++;
			b++;
			c++;
			d++;
		}
		int numeroInicial = movimientos.charAt(a) - 65;
		int letraInicial = -1 * (movimientos.charAt(b) - 56);
		int numeroFinal = movimientos.charAt(c) - 65;
		int letraFinal = -1 * (movimientos.charAt(d) - 56);
		moverFichas(letraInicial, numeroInicial, letraFinal, numeroFinal);
	}
	/**
	 * getBooleanTurno
	 * @return turnosPasar
	 */
	public boolean getBooleanTurno() {
		boolean turnosPasar = true;
		if((numeroTurno % 2) == 0) {
			turnosPasar = true;
		} else {
			turnosPasar = false;
		}
		return turnosPasar;
	}
	/**
	 * moverFichas
	 * @param mov
	 * @return 
	 */
	public void moverFichas(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal)  throws MovimientoInvalidoException {
		Ficha[][] f = new Ficha[1][1];
		f[0][0] = fichas[numeroInicial][letraInicial];
		if(getBooleanTurno() && fichas[numeroInicial][letraInicial].getColor() == "B") {
			if(fichas[numeroInicial][letraInicial].getTipo().equals("P")){
				moverPeon(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("C")){		
				moverCaballo(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("E")) {
				moverRey(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("T")) {		
				moverTorre(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("A")) {
				moverAlfil(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("R")) {
				moverReina(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}
		} else if(!getBooleanTurno() && fichas[numeroInicial][letraInicial].getColor() == "N") {
			if(fichas[numeroInicial][letraInicial].getTipo().equals("P")){
				moverPeon(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("C")){		
				moverCaballo(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("E")) {
				moverRey(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("T")) {		
				moverTorre(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("A")) {
				moverAlfil(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}else if(fichas[numeroInicial][letraInicial].getTipo().equals("R")) {
				moverReina(numeroInicial, letraInicial, numeroFinal, letraFinal);
			}
		}
	}
	/**
	 * moverPeon
	 * @param numeroInicial
	 * @param letraInicial
	 * @param numeroFinal
	 * @param letraFinal
	 * @throws MovimientoInvalidoException
	 */
	public void moverPeon(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal) throws MovimientoInvalidoException {
		boolean peonpasar = false;
		if(fichas[numeroInicial][letraInicial].getNumeroMovimientos() == 0) {
			if(fichas[numeroInicial][letraInicial].getTipo() != ""){
				if((numeroInicial - 2 == numeroFinal || numeroInicial - 1 == numeroFinal) && letraInicial == letraFinal){
					if(fichas[numeroFinal][letraFinal].getTipo().equals("")){
						fichas[numeroInicial][letraInicial].setNumeroMovimientos(1);
						peonpasar = true;
					}else{
						peonpasar = false;
					}
				}else if(fichas[numeroFinal][letraFinal].getTipo() != ""){
					if(((letraFinal-1 == letraInicial && numeroInicial - 1 == numeroFinal)||(letraFinal+1 == letraInicial && numeroInicial - 1 == numeroFinal)) && fichas[numeroInicial][letraInicial].getColor() != fichas[numeroFinal][letraFinal].getColor()){
						fichas[numeroInicial][letraInicial].setNumeroMovimientos(1);
						peonpasar = true;
					}else{
						peonpasar = false;
					}
				}else{
					peonpasar = false;
				}
			}else{
				peonpasar = false;
			}
		}else{
			if(fichas[numeroInicial][letraInicial].getTipo() != ""){
				if(numeroInicial - 1 == numeroFinal && letraInicial == letraFinal){
					if(fichas[numeroFinal][letraFinal].getTipo().equals("")){
						peonpasar = true;
					}else{
						peonpasar = false;
					}
				}else if(fichas[numeroFinal][letraFinal].getTipo() != ""){
					if(((letraFinal-1 == letraInicial && numeroInicial - 1 == numeroFinal)||(letraFinal+1 == letraInicial && numeroInicial - 1 == numeroFinal)) && fichas[numeroInicial][letraInicial].getColor() != fichas[numeroFinal][letraFinal].getColor()){
						peonpasar = true;
					}else{
						peonpasar = false;
					}
				}else{
					peonpasar = false;
				}
			}else{
				peonpasar = false;
			}
		}
		if(peonpasar) {
			fichas[numeroFinal][letraFinal] = fichas[numeroInicial][letraInicial];
			fichas[numeroInicial][letraInicial] = new Ficha(numeroInicial, letraInicial, "", "");
			cambiarNumeroTurno();
			amovido = true;
		} else {
			amovido = false;
			throw new MovimientoInvalidoException();
		}
	}
	/**
	 * moverCaballo
	 * @param numeroInicial
	 * @param letraInicial
	 * @param numeroFinal
	 * @param letraFinal
	 * @throws MovimientoInvalidoException
	 */
	public void moverCaballo(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal) throws MovimientoInvalidoException {
		boolean caballopasar = false;
		if(fichas[numeroFinal][letraFinal].getTipo().equals("") || fichas[numeroInicial][letraInicial].getColor() != fichas[numeroFinal][letraFinal].getColor()){
			if(((letraInicial - 2 == letraFinal) || (letraInicial + 2 == letraFinal) && (numeroInicial - 1 == numeroFinal || numeroInicial + 1 == numeroFinal)) || ((letraInicial - 1 == letraFinal) || (letraInicial + 1 == letraFinal) && (numeroInicial + 2 == numeroFinal || numeroInicial - 2 == numeroFinal))){
				caballopasar = true;
			}else{
				caballopasar = false;
			}
		} else {
			caballopasar = false;
		}
		if(caballopasar) {
			fichas[numeroFinal][letraFinal] = fichas[numeroInicial][letraInicial];
			fichas[numeroInicial][letraInicial] = new Ficha(numeroInicial, letraInicial, "", "");
			cambiarNumeroTurno();
			amovido = true;
		} else {
			amovido = false;
			throw new MovimientoInvalidoException();
		}
	}
	/**
	 * moverRey
	 * @param numeroInicial
	 * @param letraInicial
	 * @param numeroFinal
	 * @param letraFinal
	 * @throws MovimientoInvalidoException
	 */
	public void moverRey(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal) throws MovimientoInvalidoException {
		if((Math.abs(numeroInicial-numeroFinal) <= 1 && (Math.abs(letraInicial-letraFinal) <=1)) && (fichas[numeroInicial][letraInicial].getColor() != fichas[numeroFinal][letraFinal].getColor())) {
			fichas[numeroFinal][letraFinal] = fichas[numeroInicial][letraInicial];
			fichas[numeroInicial][letraInicial] = new Ficha(numeroInicial, letraInicial, "", "");
			cambiarNumeroTurno();
			amovido = true;
		} else {
			amovido = false;
			throw new MovimientoInvalidoException();
		}
	}
	/**
	 * moverTorre
	 * @param numeroInicial
	 * @param letraInicial
	 * @param numeroFinal
	 * @param letraFinal
	 * @throws MovimientoInvalidoException
	 */
	public void moverTorre(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal) throws MovimientoInvalidoException {
		boolean torrepasar = false;
		boolean variable = true;
		if(letraInicial == letraFinal || numeroInicial == numeroFinal){
			if(fichas[numeroInicial][letraInicial].getColor() != fichas[numeroFinal][letraFinal].getColor()) {
				if(numeroInicial > numeroFinal) {
					for(int col1 = numeroInicial-1; col1 > numeroFinal && variable; col1--){
						if(fichas[col1][letraInicial].getTipo().equals("")){
							torrepasar = true;
						}else {
							torrepasar = false;
							variable = false;
						}
					}
					if(numeroInicial-1 == numeroFinal) {
						torrepasar = true;
					}
				}
				if(numeroInicial < numeroFinal) {
					variable = true;
					for(int col1 = numeroInicial+1; col1 < numeroFinal && variable; col1++){
						if(fichas[col1][letraInicial].getTipo().equals("")){
							torrepasar = true;
						}else {
							torrepasar = false;
							variable = false;
						}
					}
					if(numeroInicial+1 == numeroFinal) {
						torrepasar = true;
					}
				}
				if(letraInicial > letraFinal) {
					variable = true;
					for(int col1 = letraInicial-1; col1 > letraFinal && variable; col1--){
						if(fichas[numeroInicial][col1].getTipo().equals("")){
							torrepasar = true;
						}else {
							torrepasar = false;
							variable = false;
						}
					}
					if(letraInicial-1 == letraFinal) {
						torrepasar = true;
					}
				}
				if(letraInicial < letraFinal) {
					variable = true;
					for(int col1 = letraInicial+1; col1 < letraFinal && variable; col1++){
						if(fichas[numeroInicial][col1].getTipo().equals("")){
							torrepasar = true;
						}else {
							torrepasar = false;
							variable = false;
						}
					}
					if(letraInicial+1 == letraFinal) {
						torrepasar = true;
					}
				}
			}
		}
		if(torrepasar) {
			fichas[numeroFinal][letraFinal] = fichas[numeroInicial][letraInicial];
			fichas[numeroInicial][letraInicial] = new Ficha(numeroInicial, letraInicial, "", "");
			cambiarNumeroTurno();
			amovido = true;
		} else {
			amovido = false;
			throw new MovimientoInvalidoException();
		}
	}
	/**
	 * moverAlfil
	 * @param numeroInicial
	 * @param letraInicial
	 * @param numeroFinal
	 * @param letraFinal
	 * @throws MovimientoInvalidoException
	 */
	public void moverAlfil(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal) throws MovimientoInvalidoException {
		boolean alfilpasar = false;
		boolean variable = true;
		int numeroInicial2 = numeroInicial;
		int letraInicial2 = letraInicial;
		if(Math.abs(numeroInicial-numeroFinal) == Math.abs(letraInicial-letraFinal)) {	
			while(numeroInicial2 > numeroFinal && letraInicial2 > letraFinal && variable) {
				numeroInicial2--;
				letraInicial2--;
				if(fichas[numeroInicial2][letraInicial2].getColor() != fichas[numeroInicial][letraInicial].getColor()){
					alfilpasar = true;
				}else {
					alfilpasar = false;
				}
			}
			while(numeroInicial2 < numeroFinal && letraInicial2 > letraFinal && variable) {
				numeroInicial2++;
				letraInicial2--;
				if(fichas[numeroInicial2][letraInicial2].getTipo() != fichas[numeroInicial][letraInicial].getColor()){
					alfilpasar = true;
				}else {
					alfilpasar = false;
				}
			}
			while(numeroInicial2 > numeroFinal && letraInicial2 < letraFinal && variable) {
				numeroInicial2--;
				letraInicial2++;
				if(fichas[numeroInicial2][letraInicial2].getTipo() != fichas[numeroInicial][letraInicial].getColor()){
					alfilpasar = true;
				}else {
					alfilpasar = false;
				}
			}
			while(numeroInicial2 < numeroFinal && letraInicial2 < letraFinal && variable) {
				numeroInicial2++;
				letraInicial2++;
				if(fichas[numeroInicial2][letraInicial2].getTipo() != fichas[numeroInicial][letraInicial].getColor()){
					alfilpasar = true;
				}else {
					alfilpasar = false;
				}
			}
		}
		if(alfilpasar) {
			fichas[numeroFinal][letraFinal] = fichas[numeroInicial][letraInicial];
			fichas[numeroInicial][letraInicial] = new Ficha(numeroInicial, letraInicial, "", "");
			cambiarNumeroTurno();
			amovido = true;
		} else {
			amovido = false;
			throw new MovimientoInvalidoException();
		}
	}
	/**
	 * moverReina
	 * @param numeroInicial
	 * @param letraInicial
	 * @param numeroFinal
	 * @param letraFinal
	 * @throws MovimientoInvalidoException
	 */
	public void moverReina(int numeroInicial, int letraInicial, int numeroFinal, int letraFinal) throws MovimientoInvalidoException {
		boolean reinapasar = false;
		boolean variable = true;
		if(letraInicial == letraFinal || numeroInicial == numeroFinal){
			if(fichas[numeroInicial][letraInicial].getColor() != fichas[numeroFinal][letraFinal].getColor()) {
				if(numeroInicial > numeroFinal) {
					for(int col1 = numeroInicial-1; col1 > numeroFinal && variable; col1--){
						if(fichas[col1][letraInicial].getTipo().equals("")){
							reinapasar = true;
						}else {
							reinapasar = false;
							variable = false;
						}
					}
					if(numeroInicial-1 == numeroFinal) {
						reinapasar = true;
					}
				}
				if(numeroInicial < numeroFinal) {
					variable = true;
					for(int col1 = numeroInicial+1; col1 < numeroFinal && variable; col1++){
						if(fichas[col1][letraInicial].getTipo().equals("")){
							reinapasar = true;
						}else {
							reinapasar = false;
							variable = false;
						}
					}
					if(numeroInicial+1 == numeroFinal) {
						reinapasar = true;
					}
				}
				if(letraInicial > letraFinal) {
					variable = true;
					for(int col1 = letraInicial-1; col1 > letraFinal && variable; col1--){
						if(fichas[numeroInicial][col1].getTipo().equals("")){
							reinapasar = true;
						}else {
							reinapasar = false;
							variable = false;
						}
					}
					if(letraInicial-1 == letraFinal) {
						reinapasar = true;
					}
				}
				if(letraInicial < letraFinal) {
					variable = true;
					for(int col1 = letraInicial+1; col1 < letraFinal && variable; col1++){
						if(fichas[numeroInicial][col1].getTipo().equals("")){
							reinapasar = true;
						}else {
							reinapasar = false;
							variable = false;
						}
					}
					if(letraInicial+1 == letraFinal) {
						reinapasar = true;
					}
				}
			}
		} else {
			int numeroInicial2 = numeroInicial;
			int letraInicial2 = letraInicial;
			if(Math.abs(numeroInicial-numeroFinal) == Math.abs(letraInicial-letraFinal)) {	
				while(numeroInicial2 > numeroFinal && letraInicial2 > letraFinal && variable) {
					numeroInicial2--;
					letraInicial2--;
					if(fichas[numeroInicial2][letraInicial2].getColor() != fichas[numeroInicial][letraInicial].getColor()){
						reinapasar = true;
					}else {
						reinapasar = false;
					}
				}
				while(numeroInicial2 < numeroFinal && letraInicial2 > letraFinal && variable) {
					numeroInicial2++;
					letraInicial2--;
					if(fichas[numeroInicial2][letraInicial2].getTipo() != fichas[numeroInicial][letraInicial].getColor()){
						reinapasar = true;
					}else {
						reinapasar = false;
					}
				}
				while(numeroInicial2 > numeroFinal && letraInicial2 < letraFinal && variable) {
					numeroInicial2--;
					letraInicial2++;
					if(fichas[numeroInicial2][letraInicial2].getTipo() != fichas[numeroInicial][letraInicial].getColor()){
						reinapasar = true;
					}else {
						reinapasar = false;
					}
				}
				while(numeroInicial2 < numeroFinal && letraInicial2 < letraFinal && variable) {
					numeroInicial2++;
					letraInicial2++;
					if(fichas[numeroInicial2][letraInicial2].getTipo() != fichas[numeroInicial][letraInicial].getColor()){
						reinapasar = true;
					}else {
						reinapasar = false;
					}
				}
			}
		}
		if(reinapasar) {
			fichas[numeroFinal][letraFinal] = fichas[numeroInicial][letraInicial];
			fichas[numeroInicial][letraInicial] = new Ficha(numeroInicial, letraInicial, "", "");
			cambiarNumeroTurno();
			amovido = true;
		} else {
			amovido = false;
			throw new MovimientoInvalidoException();
		}
	}
	/**
	 * cambiarNumeroTurno
	 */
	public void cambiarNumeroTurno() {
		numeroTurno = numeroTurno + 1;
	}
	/**
	 * getAmovido
	 * @return amovido
	 */
	public boolean getAmovido() {
		return amovido;
	} 
}