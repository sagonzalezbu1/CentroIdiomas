package control.controlPanel.procesos;

import java.awt.event.*;
import BaseDatos.*;
import control.*;
import defecto.Main;
import modelo.Centro.*;
import modelo.excepciones.*;
import modelo.excepciones.control.CampoVacio;
import modelo.excepciones.modelo.CursoExistente;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoExisteDocente;

public class CrearCursoPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("Aceptar")) {
			try {
				String nombre = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso: ");
				String tipo = Main.ventanaUsuario.getPanelP().getValue("Tipo del curso: ");
				String docente = Main.ventanaUsuario.getPanelP().getValue("Cedula del profesor que dictara el curso: ");
				String horario = Main.ventanaUsuario.getPanelP().getValue("Horario del curso: ");
				
				String curso = Curso.crearCurso(nombre, tipo, Long.parseLong(docente), horario);
				
				Main.ventanaUsuario.Popup2(curso);
				Main.ventanaUsuario.setPanelP();
				
			} catch(CampoVacio excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteCurso excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NoExisteDocente excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (NumberFormatException excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			} catch (CursoExistente excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
			
		} else if (evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}
	}
}