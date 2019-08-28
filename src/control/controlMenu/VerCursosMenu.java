package control.controlMenu;

import java.awt.event.*;
import BaseDatos.*;
import defecto.*;
import modelo.Centro.*;
import modelo.excepciones.*;

/* La clase 'VerCursos' es donde mostramos a los usuarios el nombre, el horario, el docente y la disponibilidad de cupos con los que cuenta los cursos  que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerCursos.
 */
public class VerCursosMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("VerCursos")) {
			try {
				String cursos= Curso.verCursos();
				Main.ventanaUsuario.ver(cursos);
				Main.ventanaUsuario.pack();
			} catch(NoHayCursos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}