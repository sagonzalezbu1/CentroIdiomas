package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoHayCertificados;
import modelo.excepciones.modelo.NoHaySolicitudes;

public class VerCertificadosMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("VerCertificados")) {
			try {
				Main.ventanaUsuario.ver(Estudiante.verCertificadosEstudiante((Main.user.getCedula())));
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup("Usted no es un estudiante");
			} catch (NoHayCertificados excepcion) {
				excepcion.printStackTrace();
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
