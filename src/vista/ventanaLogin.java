package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import control.*;
import control.Main;

public class ventanaLogin extends JFrame {
	
	private JPanel P1;
	private JPanel P2;
	private JPanel P3;
	private JPanel P4;
	private JPanel P5;
	private JPanel P6;
	
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
		
		//Labels Principales
		L1 = new JLabel("Bienvenido al CDI");
		L2 = new JLabel("Ingrese su codigo de usuario y su clave:");
		L3 = new JLabel("Codigo de Usuario");
		L4 = new JLabel("Clave");
		
		//Botones Principales
		B1 = new JButton("Haga clic para ver fotos");
		B2 = new JButton("Administrador");	
		B3 = new JButton("Usuario Comun");
		B4 = new JButton("Salir");
		
		
		//Textos Principales
		JTextArea T0 = new JTextArea("xD",10,20);
		T0.setEditable(false);
		JScrollPane T1 = new JScrollPane(T0);
		T2 = new JTextField(8);
		T3 = new JTextField(8);
		
		//Action listeners
		B2.addActionListener(new ControlIngresarAdmin());
		B3.addActionListener(new ControlIngresarUser());
		B4.addActionListener(new ControlSalir());
		L1.addMouseListener(
		    new MouseAdapter(){
				public void mouseEntered(MouseEvent arg0) {
	                L1.setForeground((Color.BLUE));
	            }
	            public void mouseExited(MouseEvent e) {
	            	L1.setForeground((Color.BLACK));
	            }
		    }
		    );
				
		
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
		
		JPanel P7 = new JPanel(new BorderLayout(10,10));
		P7.add(B2,BorderLayout.WEST);
		P7.add(B3,BorderLayout.EAST);
		P7.add(L2, BorderLayout.SOUTH);
		
		JPanel P8 = new JPanel(new GridLayout(2,2,10,10));
		P8.add(L3);
		P8.add(T2);
		P8.add(L4);
		P8.add(T3);
		
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
		
		getContentPane().add(Frame);	
		setVisible(true);
		pack();
		setLocationRelativeTo(null);

	}

	public long getCedula() {
		try {
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
	}
	
	public void borrar(String alert) {
		JOptionPane.showMessageDialog(null, alert, "Error al iniciar sesion" , JOptionPane.WARNING_MESSAGE);
		T3.setText(null);
		T2.setText(null);
	}
}