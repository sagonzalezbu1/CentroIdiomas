package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BaseDatos.Archivo;
import control.Main;
import modelo.Centro.Solicitud;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.NoHayDisponibilidad;

public class ResponderSolicitudesPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo de solicitud: ");
				ArrayList<Solicitud> lista = Archivo.getSolicitudes().get(tipo);
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

		}
	}

}
