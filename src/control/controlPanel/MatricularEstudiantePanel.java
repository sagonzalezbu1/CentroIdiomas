package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.Centro.Curso;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.CodigoIncorrecto;
import modelo.excepciones.CursoYaInscrito;
import modelo.excepciones.EstudianteConCertificado;
import modelo.excepciones.NoExisteCurso;
import modelo.excepciones.NoExisteEstudiante;
import modelo.excepciones.NoHayCupos;
import modelo.excepciones.NoHayEstudiantes;
import modelo.excepciones.SolicitudYaHecha;
import modelo.excepciones.UsuarioRegistrado;

public class MatricularEstudiantePanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				String cedula = Main.ventanaUsuario.getPanelP().getValue("Cedula del Estudiante: ");
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
				String aviso = Curso.MatricularEstudiante(Long.parseLong(cedula),nombre);
				Main.ventanaUsuario.Popup2(aviso);
				Main.ventanaUsuario.setPanelP();
				//Main.ventanaUsuario.getPanelP().borrar();
			}
			catch (CampoVacio exception) {
				Main.ventanaUsuario.Popup(exception.getMessage());
			}catch (NoExisteCurso exception) {
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
		}
		else if(evento.getActionCommand().equals("Borrar")){
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}

}
