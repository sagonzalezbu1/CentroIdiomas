package vista;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ventanaUsuario extends JFrame {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("Opciones de menu");
	private JMenuItem verEstudiantes = new JMenuItem("verEstudiantes");;
	private JMenuItem cerrarSeccion = new JMenuItem("cerrarSesion");
	private JMenuItem verSugerencias = new JMenuItem("verSugerencias");
	private JMenuItem promedioCurso = new JMenuItem("promedioCurso");
	public static JPanel panelPrincipal = new JPanel();
	private JTextField curso =  new JTextField(20);
	private JLabel texto1;
	private JButton aceptar = new JButton("aceptar");

	public ventanaUsuario() {
		super("Menu de usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar.add(menu);
		menu.add(cerrarSeccion);
		menu.add(promedioCurso);
		menu.add(verSugerencias);
		menu.add(verEstudiantes);
		setJMenuBar(menuBar);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setBackground(Color.black);
		setVisible(false);
		setSize(500,500);
		setLocationRelativeTo(null);

	}

	public void setControlador(ActionListener c) {
		verEstudiantes.addActionListener(c);
		cerrarSeccion.addActionListener(c);
		verSugerencias.addActionListener(c);
		promedioCurso.addActionListener(c);
		promedioCurso.addActionListener(c);
		aceptar.addActionListener(c);
	}

	public void ponerBotones() {
		menu.add(verSugerencias);
	}

	public void quitarBotones() {
		menu.remove(verSugerencias);
	}

	public void promedioCurso() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(10,10));
		texto1 = new JLabel("Ingrese nombre curso");
		panel.add(texto1,BorderLayout.NORTH);
		panel.add(curso,BorderLayout.SOUTH);
		panelPrincipal.removeAll();
		panelPrincipal.add(panel);
		panelPrincipal.add(aceptar);
		panelPrincipal.setBackground(Color.blue);
	}
	
	public void verEstudiantes(String s) {
		JPanel panel = new JPanel();
		texto1 = new JLabel(s);
		panel.add(texto1,BorderLayout.NORTH);
		panelPrincipal.removeAll();
		panelPrincipal.add(panel);
		panelPrincipal.setBackground(Color.blue);
	}
	
	public String getCurso() {
		return curso.getText();
	}

}