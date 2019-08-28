package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.EstudianteSinCursos;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHayCursos;
import modelo.excepciones.NoHayNotas;
import modelo.excepciones.NoHaySolicitudes;

public class VerNotasEstudiantePanel implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");
				Main.ventanaUsuario.ver(Estudiante.verNotasEstudiante(Long.parseLong(cedula)));
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (EstudianteSinCursos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}

		}
		if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}
}
