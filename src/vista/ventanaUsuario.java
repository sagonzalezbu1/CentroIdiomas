
package vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ventanaUsuario extends JFrame implements Botonera {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu archivoM = new JMenu("Archivo");
	private JMenu procesosM = new JMenu("Procesos y Consultas");
	private JMenu ayudaM = new JMenu("Ayuda");
	private JMenuItem usuarioMI = new JMenuItem("Usuario");
	private JMenuItem salirMI = new JMenuItem("Salir");
	private JMenuItem acercaDeMI = new JMenuItem("Acerca de");
	private JPanel panelPrincipal = new JPanel();

	public ventanaUsuario() {
		super("");
		Botonera.addControladores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar.add(archivoM);
		menuBar.add(procesosM);
		menuBar.add(ayudaM);
		archivoM.add(usuarioMI);
		archivoM.add(salirMI);
		ayudaM.add(acercaDeMI);
		setJMenuBar(menuBar);
		getContentPane().add(panelPrincipal);	
		panelPrincipal.setBackground(Color.white);
		setVisible(false);
		setSize(500, 500);
		setLocationRelativeTo(null);
		}

	public void formulario(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado){
		panelPrincipal.removeAll();
		panelPrincipal.setBackground(Color.white);
		FieldPanel panelP= new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		panelPrincipal.add(panelP);
		pack();
	}
	
	public void ver(String text) {
		panelPrincipal.removeAll();
		JTextArea texto = new JTextArea(text);
		texto.setEditable(false);
		panelPrincipal.add(texto);
		pack();
	}

	public void ingresar(ArrayList<String> opcionMenu, String nombre) {
		this.setTitle("Usuario: " + nombre);
		for (String opcion : opcionMenu) {
			procesosM.add((Botonera.botones).get(opcion));
		}
		this.setVisible(true);
	}

}