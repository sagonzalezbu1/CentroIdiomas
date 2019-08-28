package control.controlPanel.procesos;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import defecto.*;
import modelo.Centro.*;
import modelo.Usuarios.*;
import modelo.excepciones.*;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.NoHayDisponibilidad;

public class ResponderSolicitudesPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo de solicitud: ");
				ArrayList<Solicitud> lista = Solicitud.getSolicitudes().get(tipo);
				for (Solicitud x : lista) {
					int seleccion = Main.ventanaUsuario
							.responderSolicitud(x.getEstudiante().getNombre() + ": " + x.getEstudiante().getCedula());
					if (seleccion == 0) {
						Main.ventanaUsuario.Popup2(x.aceptarSolicitud());
					} else if (seleccion == 1) {
						Main.ventanaUsuario.Popup2(x.rechazarSolicitud());
					}
				}
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoHayDisponibilidad excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (Exception exepcion) {
				Main.ventanaUsuario.Popup("No hay solicitudes de este tipo");
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}