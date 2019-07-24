package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
/* La clase 'VerEstudiantesCurso' es donde mostramos a los usuarios el nombre y la cedula todos los estudiantes registrados el curso que ha elegido para ver
 *los estudiantes.
 * 
 * En esta clase estamos ejecutando el metodo localizado en 'Archivo' VerEstudiantesCurso.
 */

public class VerEstudiantesCurso extends OpcionDeMenu {
	private String nombre = "VerEstudiantesCurso";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {

		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso del cual quiere ver los estudiantes");
		String curso = entry.next();
		Curso c = Archivo.buscarCurso(curso);
		if (c == null) {
			System.out.println("\nEl curso '"+curso+"' no existe.\n");
		} else {
			System.out.println(Archivo.verEstudiantesCurso(curso));
		}

	}

	public String toString() {
		return "Ver estudiantes de un curso";
	}
}
