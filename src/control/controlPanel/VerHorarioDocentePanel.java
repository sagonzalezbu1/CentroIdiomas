package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.Usuarios.Docente;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.NoExisteDocente;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHayHorario;

public class VerHorarioDocentePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del docente: ");
				Main.ventanaUsuario.ver(Docente.verHorarioDocente(Long.parseLong(cedula)));
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}catch(NoExisteDocente excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}catch(NoHayHorario excepcion){
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}catch(NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
