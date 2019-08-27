package control.controlPanel;

import java.awt.event.*;
import javax.swing.*;
import BaseDatos.*;
import control.*;
import modelo.excepciones.*;

public class SolicitarCupoEstudiantePanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String cc = Main.ventanaUsuario.getPanelP().getValue("Cedula del Estudiante: ");
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo del curso: ");
				String solicitud = Archivo.buscarEstudiante(Long.parseLong(cc)).solicitarCupo(Long.parseLong(cc), tipo);
				Main.ventanaUsuario.Popup2(solicitud);
				// Main.ventanaUsuario.getPanelP().borrar();
			} catch (CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteEstudiante excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
				// Main.ventanaUsuario.getPanelP().borrar();
			} catch (NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (SolicitudYaHecha excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (CursoYaInscrito excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (EstudianteConCertificado excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (CursoConDisponibilidad excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}