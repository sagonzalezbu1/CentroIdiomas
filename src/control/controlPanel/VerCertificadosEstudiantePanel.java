	package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.NoExisteCurso;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHayCertificados;
import modelo.excepciones.NoHayEstudiantes;

public class VerCertificadosEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try{
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del estudiante: ");	
				String texto = Archivo.verCertificadosEstudiante(Long.parseLong(cedula));
				Main.ventanaUsuario.ver(texto);
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoHayCertificados excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
		else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
