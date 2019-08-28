package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import control.*;
import control.controlLogin.ControlBienvenida;
import control.controlLogin.ControlImagen;
import control.controlLogin.ControlIngresarAdmin;
import control.controlLogin.ControlIngresarUser;
import control.controlLogin.ControlSalir;

public class ventanaLogin extends JFrame {
	
	private JPanel P1;
	private JPanel P2;
	private JPanel P3;
	private JPanel P4;
	private JPanel P5;
	private JPanel P6;
	private JPanel P7; 
	private JPanel P8; 
	
	private JLabel L1;
	private JLabel L2;
	private JLabel L3;
	private JLabel L4;
	
	private JButton B1;
	private JButton B2;
	private JButton B3;
	private JButton B4;

	private JTextArea T0;
	private JScrollPane T1;
	private JTextField T2;
	private JTextField T3;

	private ImageIcon imagen;
	private Icon icono;

	public ventanaLogin() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel Frame = new JPanel();
		Frame.setLayout(new BorderLayout(10, 10));
		
		//Paneles principales
		P1 = new JPanel();
		P2 = new JPanel();
		P3 = new JPanel();
		P4 = new JPanel();
		P5 = new JPanel();
		P6 = new JPanel();
		P7 = new JPanel(new BorderLayout(10,10));
		P8 = new JPanel(new GridLayout(2,2,10,10));
		
		//Labels Principales
		L1 = new JLabel("Bienvenido al CDI");
		L2 = new JLabel("Ingrese su codigo de usuario y su clave:");
		L3 = new JLabel("Codigo de Usuario");
		L4 = new JLabel("Clave");
		
		//Botones Principales

		B2 = new JButton("Administrador");	
		B3 = new JButton("Usuario Comun");
		B4 = new JButton("Salir");

		//Imagen del Boton 1
		B1 = new JButton();	
		B1.setBounds(0, 0, 200, 200);
		imagen = new ImageIcon("imagenTexto.png");
		icono = new ImageIcon(imagen.getImage().getScaledInstance(B1.getWidth(), B1.getHeight(), Image.SCALE_DEFAULT));
		B1.setIcon(icono);
		
	
		
		//Textos Principales
		JTextArea T0 = new JTextArea("El objetivo de este proyecto es el de\npresentar un programa que administre\n"
				+ "un centro de idiomas, desde las\nmatrículas hasta la entrega de\ncertificados, pasando por las"
				+ "\ncalificaciones de cada estudiante en los\ndiferentes cursos que se ofrezcan.\nDentro del programa, "
				+ "queremos\ngestionar las principales acciones o\nprocesos que puedan necesitar\nestudiantes, docentes "
				+ "y administrativos\npara un correcto funcionamiento del\ncentro; además de facilitar la realización\n"
				+ "de estos procesos dentro del centro,\npara evitar trámites enredados o\ntediosos, pudiendo manejar "
				+ "\nprácticamente todo lo necesario desde este.\nSabemos lo importante que es hoy en \ndía un sistema "
				+ "que gestione\nadecuadamente la información de una\ninstitución educativa (universidad,\ncolegio, etc), "
				+ "por lo que quisimos\ndedicarnos a algo no tan convencional\ncomo lo es un centro de idiomas y crear"
				+ "dicho sistema para manejar desde allí\nlo más importante para éste.\nPrograma diseñado por "
				+ "Santiago\nBustamante, Catherin Patiño, David\nPerez y Luis Suarez.",10,20);
		//T0.setSize(20,20);
		T0.setLineWrap(true);
		T0.setEditable(false);
		JScrollPane T1 = new JScrollPane(T0);
		T2 = new JTextField(8);
		T3 = new JTextField(8);
		
		//Action listeners
		B1.addActionListener(new ControlImagen());
		B2.addActionListener(new ControlIngresarAdmin());
		B3.addActionListener(new ControlIngresarUser());
		B4.addMouseListener(new ControlSalir());
		L1.addMouseListener(new ControlBienvenida());
				
		
		//Hagamos el panel izquierdo (P1)
		
		P1.setLayout(new BorderLayout(10,10));
		
		P3.add(L1);
		P4.add(B1);
		
		P1.add(P3,BorderLayout.NORTH);
		P1.add(P4,BorderLayout.CENTER);
		
		//Hagamos el panel derecho (P2)
		
		P2.setLayout(new BorderLayout(10,10));
		
		P5.add(T1, BorderLayout.NORTH);
		P6.setLayout(new BorderLayout(10,10));
		
	
		P7.add(B2,BorderLayout.WEST);
		P7.add(B3,BorderLayout.EAST);
	
		
		JPanel P9 = new JPanel(new BorderLayout(10,10));
		P9.add(P8,BorderLayout.CENTER);
		P9.add(B4,BorderLayout.SOUTH);
		
		P2.add(P5, BorderLayout.NORTH);
		P2.add(P7, BorderLayout.CENTER);
		P2.add(P9, BorderLayout.SOUTH);
		
		//Añadimos todo al panel Principal
		
		Frame.add(P1, BorderLayout.WEST);
		Frame.add(P2, BorderLayout.EAST);
		
		//Lanzamos la ventana
		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Frame.setBorder(padding);
		getContentPane().add(Frame);	
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}

	public long getCedula() {
		try {
			
			if(T2.getText().equals("")) {
				return -1;
			}
			
			return Long.parseLong(T2.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public String getContrasena() {
		return T3.getText();
	}
	
	public void ingresar() {
		Main.ventanaLogin.setVisible(false);
		T2.setText(null);
		T3.setText(null);
	}
	public int salir() {
		return JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Esta proximo a salir del programa", JOptionPane.YES_NO_OPTION);
	}
	public void borrar(String alert) {
		JOptionPane.showMessageDialog(null, alert, "Error al iniciar sesion" , JOptionPane.WARNING_MESSAGE);
		T3.setText(null);
		T2.setText(null);
	}
	
	public void cambiarImagen(String nombreImagen) {
		B1.setBounds(0, 0, 200, 200);
		imagen = new ImageIcon(nombreImagen);
		icono = new ImageIcon(imagen.getImage().getScaledInstance(B1.getWidth(), B1.getHeight(), Image.SCALE_DEFAULT));
		B1.setIcon(icono);
		pack();
	}
	public void ingresarAdmin() {
		P7.add(L2, BorderLayout.SOUTH);
		P8.add(L3);
		P8.add(T2);
		P8.add(L4);
		P8.add(T3);
		
		B3.setText("Usuario Comun");
		B3.setActionCommand("Usuario Comun");
		B2.setText("Administrador Complete y Nuevamente Clic");
		B2.setActionCommand("AdministradorLogin");
		pack();
	}
	public void ingresarUser() {
		P7.add(L2, BorderLayout.SOUTH);
		P8.add(L3);
		P8.add(T2);
		P8.add(L4);
		P8.add(T3);
		
		B3.setText("Usuario Comun Complete y Nuevamente Clic");
		B3.setActionCommand("Usuario ComunLogin");
		B2.setText("Administrador");
		B2.setActionCommand("Administrador");
		pack();
	}
	public JLabel getL1() {
		return L1;
	}
}