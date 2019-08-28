package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.controlPanel.procesos.PromedioCursoPanel;
import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoHaySolicitudes;

public class VerSolicitudesMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("VerSolicitudes")) {
			try {
				Main.ventanaUsuario.ver(Estudiante.verSolicitudesEstudiante(Main.user.getCedula()));
			} catch (NoHaySolicitudes excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup("Usted no es un estudiante");
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
