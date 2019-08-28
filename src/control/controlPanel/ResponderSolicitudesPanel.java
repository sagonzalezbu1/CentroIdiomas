package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import BaseDatos.Archivo;
import control.Main;
import modelo.Centro.Solicitud;
import modelo.excepciones.CampoVacio;

public class ResponderSolicitudesPanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup("Campos vacios");
			}
		} else if (evento.getActionCommand().equals("Borrar")) {

		}
	}

}
