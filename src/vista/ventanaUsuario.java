
package vista;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

import control.controlMenu.CerrarSesionMenu;

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
		setJMenuBar(menuBar);
		getContentPane().add(panelPrincipal);	
		panelPrincipal.setBackground(Color.white);
		setVisible(false);
		setSize(600, 250);
		setLocationRelativeTo(null);
		salirMI.addActionListener(new CerrarSesionMenu());
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
}