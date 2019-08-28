package control.controlMenu.procesos;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import BaseDatos.*;
import control.*;
import control.controlPanel.*;
import control.controlPanel.procesos.CrearCursoPanel;
import defecto.Main;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por el Administrativo para crear nuevos cursos para los estudiantes.
 * 
 * En esta clase se crean objetos de tipo Curso y se les asignan sus respectivos atributos.*/
public class CrearCursoMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("CrearCurso")) {
			String tituloCriterios = "Criterio";
			String[] criteriosArray = {"Nombre del curso: ","Tipo del curso: ","Cedula del profesor que dictara el curso: ","Horario del curso: "};
			String tituloValores = "Valores";
			String[] valoresArray = {null,null,null,null};
			boolean[] habilitado = {true,true,true,true};
			Main.ventanaUsuario.formulario(tituloCriterios, criteriosArray, tituloValores, valoresArray, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new CrearCursoPanel());
			Main.ventanaUsuario.getPanelP().nombre("Crear curso");
			Main.ventanaUsuario.getPanelP().descripcion("Crea un nuevo curso.\nTenga en cuenta que el horario se debe introducir con el siguiente formato:\n(Dia1-Dia2_Horainicio-Horafin)");
			Main.ventanaUsuario.pack();
		}
	}
}