package controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BaseDatos.Archivo;
import control.Main;

/* La clase 'VerTodosLosEstudiantes' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes que se encuentren en 'Archivo'.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerTodosLosEstudiantes.*/
public class VerTodosLosEstudiantesMenu implements ActionListener {
	
	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerTodosLosEstudiante")) {
			String Estudiantes= Archivo.verEstudiantes();
			Main.ventanaUsuario.ver(Estudiantes);
		}

	}
	
}
