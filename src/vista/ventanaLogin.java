package vista;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.ControlIngresar;

public class ventanaLogin extends JFrame {
	private JButton entrar;
	private JTextField cedula;
	private JTextField contrasena;
	private JLabel texto1;
	private JLabel texto2;

	public ventanaLogin() {
		super("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout(10, 10));
		JPanel izquierdo = new JPanel();
		JPanel derecho = new JPanel();
		cedula = new JTextField(8);
		contrasena = new JTextField(8);
		texto1 = new JLabel("cedula: ");
		texto2 = new JLabel("contraseña: ");
		izquierdo.add(texto1);
		izquierdo.add(texto2);
		derecho.add(cedula);
		derecho.add(contrasena);
		entrar = new JButton("entrar");
		entrar.addActionListener(new ControlIngresar());
		panelPrincipal.add(izquierdo, BorderLayout.WEST);
		panelPrincipal.add(derecho, BorderLayout.EAST);
		panelPrincipal.add(entrar, BorderLayout.SOUTH);
		getContentPane().add(panelPrincipal);
		setVisible(true);
		setSize(500,500);
		setLocationRelativeTo(null);

	}

	public long getCedula() {
		try {
			return Long.parseLong(cedula.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public String getContrasena() {

		return contrasena.getText();

	}
	
	public void borrar() {
		contrasena.setText(null);
		cedula.setText(null);
		
	}
	
}