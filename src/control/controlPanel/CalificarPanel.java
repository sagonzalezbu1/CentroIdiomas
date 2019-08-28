package control.controlPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import defecto.Main;
import modelo.Centro.Curso;
import modelo.Usuarios.Docente;
import modelo.Usuarios.Estudiante;
import modelo.excepciones.CampoVacio;
import modelo.excepciones.DocenteIncorrecto;
import modelo.excepciones.NoExisteCurso;
import modelo.excepciones.NoHayEstudiantes;

public class CalificarPanel implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("Aceptar")) {
			try {
				String curso = Main.ventanaUsuario.getPanelP().getValue("Nombre del curso al que desea Calificar: ");		
				long cedula = Long.parseLong(Main.ventanaUsuario.getPanelP().getValue("Cedula del docente que da el curso: "));	
				Docente.PreCalificar(curso, cedula);
				for(Estudiante x : (ArrayList<Estudiante>)Curso.buscarCurso(curso).getEstudiantes()) {
					Float respuesta = Main.ventanaUsuario.calificar("Ingrese la nota de " + x.getCedula());
					x.calificar(curso,respuesta);
				}
				Main.ventanaUsuario.Popup2("Se ha calificado con exito a los estudiantes de " + curso);
				Main.ventanaUsuario.setPanelP();
			}
			catch(CampoVacio exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}
			catch(NoExisteCurso exception2) {
				Main.ventanaUsuario.Popup(exception2.getMessage());
			}
			catch(DocenteIncorrecto exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}
			catch(NoHayEstudiantes exception1) {
				Main.ventanaUsuario.Popup(exception1.getMessage());
			}
		}
		else if(evento.getActionCommand().equals("Borrar")) {
			Main.ventanaUsuario.getPanelP().borrar();
		}

	}

}
