package control.controlPanel.procesos;

import java.awt.event.*;
import javax.swing.*;
import BaseDatos.*;
import control.*;
import defecto.Main;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.*;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.CursoConDisponibilidad;
import modelo.excepciones.modelo.CursoYaInscrito;
import modelo.excepciones.modelo.EstudianteConCertificado;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.SolicitudYaHecha;

public class SolicitarCupoEstudiantePanel implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String cc = Main.ventanaUsuario.getPanelP().getValue("Cedula del Estudiante: ");
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo del curso: ");
				String solicitud = Estudiante.buscarEstudiante(Long.parseLong(cc)).solicitarCupo(Long.parseLong(cc), tipo);
				
				Main.ventanaUsuario.Popup2(solicitud);
				Main.ventanaUsuario.setPanelP();
				
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