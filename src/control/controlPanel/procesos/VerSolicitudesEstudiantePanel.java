package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoHaySolicitudes;

public class VerSolicitudesEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try{
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");
				Main.ventanaUsuario.ver(Estudiante.verSolicitudesEstudiante(Long.parseLong(cedula)));
			}catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}catch(NoHaySolicitudes excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}catch(NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}catch(NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}else if(evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
