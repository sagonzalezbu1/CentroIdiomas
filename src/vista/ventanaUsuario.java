package vista;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ventanaUsuario extends JFrame implements Botonera{
	private JMenuBar menuBar = new JMenuBar();
	private JMenu archivo = new JMenu("Archivo");
	private JMenu menu = new JMenu("Opciones de menu");
	private JMenu ayuda = new JMenu("Ayuda");
	public static JPanel panelPrincipal = new JPanel();
	private JTextField curso = new JTextField(20);
	private JLabel texto1;
	private JButton aceptar = new JButton("aceptar");
	private static String nombreUsuario = "";

	public ventanaUsuario() {
		super(nombreUsuario);
		Botonera.addControladores();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar.add(archivo);
		menuBar.add(menu);
		menuBar.add(ayuda);

		setJMenuBar(menuBar);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setBackground(Color.black);
		setVisible(false);
		setSize(500, 500);
		setLocationRelativeTo(null);

	}

	public void ingresar(ArrayList<String> opmenu, String nombre) {
		this.setTitle(nombre);
		for (String op : opmenu) {
			menu.add((Botonera.botones).get(op));
		}
		this.setVisible(true);
	}

	public void Ver(String tex) {
		panelPrincipal.removeAll();
		JTextArea texto= new JTextArea(tex);
		texto.setEditable(false);
		panelPrincipal.add(texto);
		pack();
	}

	public void setControlador(ActionListener c) {
		aceptar.addActionListener(c);
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

}