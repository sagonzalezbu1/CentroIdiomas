package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import defecto.Main;
import modelo.Usuarios.Administrador;
import modelo.Usuarios.Usuario;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.EstudianteSinCursos;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoExisteUsuario;

public class VerMenuUsuarioPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del usuario: ");
				Main.ventanaUsuario.ver(new Administrador().userSystemMenu(Long.parseLong(cedula)));
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteUsuario excepcion) {
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
