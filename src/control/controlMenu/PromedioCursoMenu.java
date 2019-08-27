package control.controlMenu;

import java.awt.event.*;
import java.text.*;
import java.util.*;
import BaseDatos.*;
import control.*;
import control.controlPanel.*;
import modelo.Centro.*;
import modelo.Usuarios.*;


/*Esta clase es usada por Administrativo y Docente para ver el promedio de las notas de 
 * los estudiantes de cierto curso.*/
public class PromedioCursoMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("PromedioCurso")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Nombre del curso: "};
			String[] valores = {""};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new PromedioCursoPanel());
			Main.ventanaUsuario.getPanelP().nombre("Promedio de un curso");
			Main.ventanaUsuario.getPanelP().descripcion("Recibe el nombre de un curso y luego muestra el promedio de las notas de\neste curso.");
			Main.ventanaUsuario.pack();
		}
	}
}