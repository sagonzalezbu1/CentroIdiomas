package control.controlMenu.procesos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;



import control.controlPanel.procesos.FinalizeCursoPanel;
import control.controlPanel.procesos.HacerSugerenciaPanel;
import control.controlPanel.procesos.RegistrarEstudiantePanel;
import defecto.Main;
import modelo.Centro.*;
import modelo.Usuarios.*;
import modelo.excepciones.modelo.NoHayNotas;

/*Esta clase es usada por Administrativo para finalizar los cursos, algo as�
 * como cerrar el per�odo de calificaciones al acabar el curso.
 * 
 * En esta clase se ejecuta el m�todo finalizeCurso localizado en la clase Curso.*/
public class FinalizeCursoMenu implements ActionListener{
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals("FinalizeCurso")) {
			String tituloCriterios="Criterio";
			String tituloValores="Valor";
			String[] criterios= {"Nombre del curso: "};
			String[] valores = {null};
			boolean[] habilitado= {true};
			Main.ventanaUsuario.formulario(tituloCriterios, criterios, tituloValores, valores, habilitado);
			Main.ventanaUsuario.getPanelP().setControlador(new FinalizeCursoPanel());
			Main.ventanaUsuario.getPanelP().nombre("Finalizar Curso");
			Main.ventanaUsuario.getPanelP().descripcion("Permite finalizar un curso de los que ya estan abierto en el CDI.");
			Main.ventanaUsuario.pack();
		}
	}
}