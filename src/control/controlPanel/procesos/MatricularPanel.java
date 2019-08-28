package control.controlPanel.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import defecto.Main;
import modelo.Centro.Curso;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.CursoYaInscrito;
import modelo.excepciones.modelo.EstudianteConCertificado;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoHayCupos;
import modelo.excepciones.modelo.NoHayEstudiantes;
import modelo.excepciones.modelo.SolicitudYaHecha;

public class MatricularPanel implements ActionListener {
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
				String aviso = Curso.MatricularEstudiante(Main.user.getCedula(), nombre);
				Main.ventanaUsuario.Popup2(aviso);
				Main.ventanaUsuario.setPanelP();
				// Main.ventanaUsuario.getPanelP().borrar();
			} catch (CampoVacio exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (NoExisteCurso exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (NoExisteEstudiante exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (NoHayCupos exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (CursoYaInscrito exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (EstudianteConCertificado exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (SolicitudYaHecha exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			} catch (NumberFormatException exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			}
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}