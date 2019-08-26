package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;

public class VerNotasEstudiantePanel implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");
			try{
				System.out.println("Hola");
				Main.ventanaUsuario.ver(Archivo.verNotasEstudiante(Long.parseLong(cedula)));
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, e, "Error al iniciar sesion" , JOptionPane.WARNING_MESSAGE);
			}
		}

	}
}
