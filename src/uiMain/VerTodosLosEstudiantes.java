package uiMain;

import gestorAplicacion.Centro.Archivo;
/* La clase 'VerTodosLosEstudiantes' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes que se encuentren en 'Archivo'.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerTodosLosEstudiantes.
 */
public class VerTodosLosEstudiantes extends OpcionDeMenu {
	private String nombre = "VerTodosLosEstudiantes";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		//
		if (Archivo.verEstudiantes().equals("\nEstudiantes:\n")) {
			System.out.println("No hay estudiantes registrados.\n");
		} else {
			System.out.println(Archivo.verEstudiantes());
		}
	}

	public String toString() {
		return "Ver todos los estudiantes";
	}
}
