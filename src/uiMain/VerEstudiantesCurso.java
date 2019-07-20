package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class VerEstudiantesCurso extends OpcionDeMenu {
	private String nombre = "VerEstudiantesCurso";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {

		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso del cual quiere ver los estudiantes");
		String curso = entry.next();

		System.out.println(Archivo.verEstudiantesCurso(curso));

	}

	public String toString() {
		return "Ver estudiantes de un curso";
	}
}
