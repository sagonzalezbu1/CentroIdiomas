package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHayCertificados;
import modelo.excepciones.NoHaySolicitudes;

public class VerCertificadosMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("VerCertificados")) {
			try {
				Main.ventanaUsuario.ver(Archivo.verCertificadosEstudiante((Main.user.getCedula())));
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
