
package vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import control.controlMenu.*;
import control.controlMenu.archivo.SalirMenu;
import control.controlMenu.archivo.UsuarioMenu;
import control.controlMenu.ayuda.AcercaDe;
import defecto.Main;


public class ventanaUsuario extends JFrame implements Botonera {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu archivoM = new JMenu("Archivo");
	private JMenu procesosM = new JMenu("Procesos y Consultas");
	private JMenu ayudaM = new JMenu("Ayuda");
	private JMenuItem usuarioMI = new JMenuItem("Usuario");
	private JMenuItem salirMI = new JMenuItem("Salir");
	private JMenuItem acercaDeMI = new JMenuItem("Acerca de");
	private FieldPanel panelPrincipal = new FieldPanel();

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
		acercaDeMI.addActionListener(new AcercaDe());
		usuarioMI.addActionListener(new UsuarioMenu());
		setJMenuBar(menuBar);
		getContentPane().add(panelPrincipal);	
		panelPrincipal.setBackground(Color.white);
		setVisible(false);
		setSize(600, 250);
		setLocationRelativeTo(null);
		salirMI.addActionListener(new SalirMenu());
		}

	public void formulario(String tituloCriterios, String[] criterios, String tituloValores, String[] valores,
			boolean[] habilitado){
		panelPrincipal.removeAll();
		panelPrincipal.setBackground(Color.white);
		panelPrincipal= new FieldPanel(tituloCriterios,criterios,tituloValores,valores,habilitado);
		getContentPane().removeAll();
		getContentPane().add(panelPrincipal);
		pack();
	}
	
	public void ver(String text) {
		panelPrincipal= new FieldPanel();
		panelPrincipal.formulario(text);
		getContentPane().removeAll();
		getContentPane().add(panelPrincipal);
		pack();
	}

	public void ingresar(ArrayList<String> opcionMenu, String nombre) {
		this.setTitle("Usuario: " + nombre);
		int cont = 0;
		procesosM.removeAll();
		for (String opcion : opcionMenu) {
			if(opcion.equals("RegistrarEstudiante") ||opcion.equals("RegistrarDocente") || opcion.equals("RegistrarAdministrativo")){
				if (cont == 0) {
					cont++;
					JMenu register = new JMenu("Registar");
					register.add((Botonera.botones).get("RegistrarEstudiante"));	
					register.add((Botonera.botones).get("RegistrarDocente"));
					register.add((Botonera.botones).get("RegistrarAdministrativo"));	
					procesosM.add(register);
				}		
			}
			else {
				procesosM.add((Botonera.botones).get(opcion));				
			}
		}
		this.setVisible(true);
	}
	
	public FieldPanel getPanelP() {
		return panelPrincipal;
	}
	
	public int responderSolicitud(String text) {
		String[] options = { "Aceptar", "Rechazar", "Cancelar"};
		int seleccion = JOptionPane.showOptionDialog(null, text,
				"Responder Solicitud", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
				options[0]);
		return seleccion;
	}
	
	public void setPanelP() {
		panelPrincipal = new FieldPanel();
		getContentPane().removeAll();;
		getContentPane().add(panelPrincipal);
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public void Popup(String error) {
		JOptionPane.showMessageDialog(null, error, "Error" , JOptionPane.WARNING_MESSAGE);
	}
	public void Popup2(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Aviso" , JOptionPane.INFORMATION_MESSAGE);
	}
	public Float calificar(String notade) {
		Object[] options1 = { "Aceptar", "Poner 0"};

		JPanel panel = new JPanel();
		panel.add(new JLabel(notade));
		JTextField textField = new JTextField(10);
		panel.add(textField);

		int result = JOptionPane.showOptionDialog(null, panel, "Calificacion", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null, options1, null);
		if (result == 0) {
			try {
				if(textField.getText().equals("")) {
					textField.setText("0");
					return Float.parseFloat((textField.getText()));
				}
				else {
					if(Float.parseFloat(textField.getText())>= 0 || Float.parseFloat(textField.getText())<= 5);
					return Float.parseFloat((textField.getText()));
				}
			}
			catch(NumberFormatException exception) {
				textField.setText("0");
				return Float.parseFloat((textField.getText()));
			}
				
		}
		else /*(result == 1)*/ {
			textField.setText("0");
			return Float.parseFloat((textField.getText()));
		}
		//return null;
	}
}