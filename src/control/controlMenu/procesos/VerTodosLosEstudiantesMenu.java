package control.controlMenu.procesos;

import java.awt.event.*;
import defecto.*;
import modelo.Usuarios.*;
import modelo.excepciones.*;
import modelo.excepciones.modelo.NoHayEstudiantes;


/* La clase 'VerTodosLosEstudiantes' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes que se encuentren en 'Archivo'.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerTodosLosEstudiantes.*/
public class VerTodosLosEstudiantesMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerTodosLosEstudiantes")) {
			try {
				String Estudiantes = Estudiante.verEstudiantes();
				Main.ventanaUsuario.ver(Estudiantes);
				Main.ventanaUsuario.getPanelP().nombre("Ver todos los estudiantes");
				Main.ventanaUsuario.getPanelP().descripcion("Muestra todos los estudiantes que se encuentran registrados en el sistema");
				Main.ventanaUsuario.pack();
			} catch (NoHayEstudiantes excepcion) {
				Main.ventanaUsuario.Popup(excepcion.getMessage());
			}
		}
	}
}