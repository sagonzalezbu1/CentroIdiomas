
package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ventanaUsuario extends JFrame implements Botonera{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu archivoM = new JMenu("Archivo");
	private JMenu procesosM = new JMenu("Procesos y Consultas");
	private JMenu ayudaM = new JMenu("Ayuda");
	private JMenuItem usuarioMI = new JMenuItem("Usuario");
	private JMenuItem salirMI = new JMenuItem("Salir");
	private JMenuItem acercaDeMI = new JMenuItem("Acerca de");
	private JPanel panelPrincipal = new JPanel();
    private JLabel texto1;
    private JTextField curso = new JTextField(20);
    private JButton aceptar = new JButton("aceptar");
	public ventanaUsuario() {
		super("");
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

	public void promedioCurso() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(10, 10));
		texto1 = new JLabel("Ingrese nombre curso");
		panel.add(texto1, BorderLayout.NORTH);
		panel.add(curso, BorderLayout.SOUTH);
		panelPrincipal.removeAll();
		panelPrincipal.add(panel);
		panelPrincipal.add(aceptar);
		panelPrincipal.setBackground(Color.blue);
	}

	public void verEstudiantes(String s) {
		JPanel panel = new JPanel();
		texto1 = new JLabel(s);
		panel.add(texto1, BorderLayout.NORTH);
		panelPrincipal.removeAll();
		panelPrincipal.add(panel);
		panelPrincipal.setBackground(Color.blue);
	}

	public String getCurso() {
		return curso.getText();
	}

	public void ver(String text) {
		JTextArea texto = new JTextArea(text);
		texto.setEditable(false);
		panelPrincipal.add(texto);
		pack();
	}
	

	public void ingresar(ArrayList<String> opcionMenu, String nombre) {
		this.setTitle("Usuario"+nombre);
		for(String opcion : opcionMenu) {
			procesosM.add((Botonera.botones).get(opcion));
		}
		this.setVisible(true);
	}

}