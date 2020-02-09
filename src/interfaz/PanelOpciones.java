package interfaz;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.TitledBorder;
/**
 * 
 *	@author <b>Kevin Zarama-kz</b>
 *	@version 1.0z - 28/10/2017
 *
 */
public class PanelOpciones extends JPanel implements ActionListener{
	/**
	 * atributos de la clase PanelOpciones
	 */
	public final static String ROTAR = "ROTAR";
	public final static String VOLVER_A_ROTAR = "VROTAR";
	public final static String JUGAR = "JUGAR";
	private JButton btRotar;
	private JButton btRotarInverso;
	private JButton btJugar;
	private JTextField txtMov;
	private JLabel labMovimientos;
	private InterfazAjedrez interfaz;
	private String coordenadas;
	/**
	 * constructor de la clase
	 * @param interfaz
	 */
	public PanelOpciones(InterfazAjedrez interfaz) {
		coordenadas = "";
		this.interfaz = interfaz;
		setLayout(new GridLayout(10, 1));
		TitledBorder border = BorderFactory.createTitledBorder("OPCIONES");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		btRotar = new JButton("ROTAR");
		btRotar.setActionCommand(ROTAR);
		btRotar.addActionListener(this);
		btRotarInverso = new JButton("VOLVER A ROTAR");
		btRotarInverso.setActionCommand(VOLVER_A_ROTAR);
		btRotarInverso.addActionListener(this);
		btRotarInverso.setEnabled(false);
		btJugar = new JButton("JUGAR");
		btJugar.setActionCommand(JUGAR);
		btJugar.addActionListener(this);
		labMovimientos = new JLabel("INGRESE COORDENADAS");
		txtMov = new JTextField();
		add(btRotar);
		add(btRotarInverso);
		add(txtMov);
		add(labMovimientos);
		add(btJugar);
	}
	/**
	 * actionPerformed
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if (comando.equals(ROTAR)) {
			rotar();
			btRotarInverso.setEnabled(true);
			btRotar.setEnabled(false);
			btJugar.setEnabled(false);
		}
		if (comando.equals(VOLVER_A_ROTAR)) {
			rotar();
			rotar();
			rotar();
			btRotar.setEnabled(true);
			btRotarInverso.setEnabled(false);
			btJugar.setEnabled(true);
		}
		if (comando.equals(JUGAR)) {
			try {
				interfaz.mover(txtMov.getText().toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				interfaz.setExtendedState(interfaz.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				interfaz.setExtendedState(JFrame.NORMAL);
			}
		}
	}
	/**
	 * rotar
	 */
	public void rotar() {
		interfaz.rotarTablero();
		interfaz.setExtendedState(interfaz.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		interfaz.setExtendedState(JFrame.NORMAL);
	}
	/**
	 * setCoordenadas
	 * @param f
	 * @param c
	 */
	public void setCoordenadas(int f, int c) {
		this.coordenadas += f + "" + c;
		mostrarNotacion(f, c);
	}
	/**
	 * mostrarNotacion
	 * @param f
	 * @param c
	 */
	public void mostrarNotacion(int f, int c) {
		if(coordenadas.length() == 4) {
			
			int numeroInicial2 = (56 - ((char) (coordenadas.charAt(0))));
			char letraInicial2 = (char) (coordenadas.charAt(1) + 17);
			int numeroFinal2 = (56 - ((char) (coordenadas.charAt(2))));
			char letraFinal2 = (char) (coordenadas.charAt(3) + 17);
			
			int letIni = (int) (coordenadas.charAt(0)) - 48;
			int numIni = (int) (coordenadas.charAt(1)) - 48;
			
			if(interfaz.darFichas()[letIni][numIni].getTipo() == "P") {
				txtMov.setText(letraInicial2 + "" + numeroInicial2 + "" + letraFinal2 + "" + numeroFinal2);
				coordenadas = "";
			} else {
				if(interfaz.darFichas()[letIni][numIni].getTipo() == "E") {
					txtMov.setText("R" + "" + letraInicial2 + "" + numeroInicial2 + "" + letraFinal2 + "" + numeroFinal2);
					coordenadas = "";
				} else {
					txtMov.setText(interfaz.darFichas()[letIni][numIni].getTipo() + "" + letraInicial2 + "" + numeroInicial2 + "" + letraFinal2 + "" + numeroFinal2);
					coordenadas = "";
				}
			}
		}
	}
}