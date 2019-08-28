package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import BaseDatos.Archivo;
import control.OpcionDeMenu;
import control.controlPanel.FinalizeCursoPanel;
import control.controlPanel.HacerSugerenciaPanel;
import control.controlPanel.RegistrarEstudiantePanel;
import defecto.Main;
import modelo.Centro.*;
import modelo.Usuarios.*;
import modelo.excepciones.NoHayNotas;

/*Esta clase es usada por Administrativo para finalizar los cursos, algo así
 * como cerrar el período de calificaciones al acabar el curso.
 * 
 * En esta clase se ejecuta el método finalizeCurso localizado en la clase Curso.*/
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