package control.controlMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BaseDatos.Archivo;
import defecto.Main;
import modelo.excepciones.NoHayEstudiantes;

/* La clase 'VerTodosLosEstudiantes' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes que se encuentren en 'Archivo'.
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerTodosLosEstudiantes.*/
public class VerTodosLosEstudiantesMenu implements ActionListener {

	public void actionPerformed(ActionEvent evento) {

		if (evento.getActionCommand().equals("VerTodosLosEstudiantes")) {
			try {
				String Estudiantes = Archivo.verEstudiantes();
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
