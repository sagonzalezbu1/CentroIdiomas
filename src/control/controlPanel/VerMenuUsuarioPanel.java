package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.Usuarios.Administrador;
import modelo.Usuarios.Usuario;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.EstudianteSinCursos;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoExisteUsuario;

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
