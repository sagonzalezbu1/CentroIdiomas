package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHaySolicitudes;

public class VerSolicitudesEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try{
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");
				Main.ventanaUsuario.ver(Archivo.verSolicitudesEstudiante(Long.parseLong(cedula)));
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
