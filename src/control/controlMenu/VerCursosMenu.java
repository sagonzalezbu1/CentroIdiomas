package control.controlMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import control.Main;
import modelo.excepciones.NoHayCursos;
/* La clase 'VerCursos' es donde mostramos a los usuarios el nombre, el horario, el docente y la disponibilidad de cupos con los que cuenta los cursos  que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerCursos.
 */
public class VerCursosMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getActionCommand().equals("VerCursos")) {
			try{
				String cursos= Archivo.verCursos();
				Main.ventanaUsuario.ver(cursos);
				Main.ventanaUsuario.getPanelP().nombre("Ver cursos");
				Main.ventanaUsuario.getPanelP().descripcion("Imprime el nombre, horario, docente que dicta el curso y los cupos disponibles que hay en los cursos que tenemos en la base de datos.");
				Main.ventanaUsuario.pack();
			}catch(NoHayCursos excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
		
	}
	
}