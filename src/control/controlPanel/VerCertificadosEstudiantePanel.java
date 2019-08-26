	package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;

public class VerCertificadosEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");
			
			String texto = Archivo.verCertificadosEstudiante(Long.parseLong(cedula));
			Main.ventanaUsuario.ver(texto);
		}
		else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
