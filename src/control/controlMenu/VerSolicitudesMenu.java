package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.controlPanel.PromedioCursoPanel;
import defecto.Main;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHaySolicitudes;

public class VerSolicitudesMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("VerSolicitudes")) {
			try {
				Main.ventanaUsuario.ver(Archivo.verSolicitudesEstudiante(Main.user.getCedula()));
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
