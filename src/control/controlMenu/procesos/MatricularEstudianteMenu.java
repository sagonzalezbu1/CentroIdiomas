package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;



import control.controlPanel.procesos.MatricularEstudiantePanel;
import control.controlPanel.procesos.SolicitarCupoEstudiantePanel;
import defecto.Main;
import modelo.Centro.*;
import modelo.Usuarios.*;
import modelo.excepciones.modelo.EstudianteSinCursos;
import modelo.excepciones.modelo.NoExisteEstudiante;

/*Esta clase es usada por Estudiante para inscribirse a los cursos disponibles.
 * 
 * En esta clase se ejecuta el método matricular localizado en la clase Curso.*/
public class MatricularEstudianteMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("MatricularEstudiante")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Cedula del Estudiante: ","Nombre del curso: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null};
			boolean[] habilitado = {true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new MatricularEstudiantePanel());
			Main.ventanaUsuario.getPanelP().descripcion("Matricula a un estudiante en un curso");
			Main.ventanaUsuario.getPanelP().nombre("Matricular un estudiante");
			Main.ventanaUsuario.pack();			
		}
	}
}