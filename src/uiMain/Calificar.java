package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

public class Calificar extends OpcionDeMenu {
	private String nombre = "Calificar";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {
		// Se califica buscando primero el grupo y luego el estudiante
		Scanner entry = new Scanner(System.in);
		System.out.println("Introduzca el nombre del grupo al que desea calificar: ");
		String aux = entry.next();
		boolean bool = false;

		for (Curso x : Archivo.getCursos()) {
			if (x.getNombreCurso().equals(aux)) {
				bool = true;
				System.out.println("Introduzca la cedula del docente que da el curso: ");
				long aux4 = entry.nextLong();
				if (aux4 == x.getDocente().getCedula()) {
					if (x.getEstudiantes().size() == 0) {
						System.out.println("\nEste curso no tiene estudiantes inscritos.\n");
					} else {

						for (Estudiante y : x.getEstudiantes()) {
							long aux2 = y.getCedula();
							System.out.println("Ingrese la nota del estudiante con ID " + aux2
									+ " (si la nota es un float escribirla con coma): ");
							float aux3 = entry.nextFloat();
							while(aux3<0 || aux3>5) {
								System.out.println("Ingrese una nota valida: ");
								aux3 = entry.nextFloat();
							}
							System.out.println("");
							y.calificar(aux, aux3);
						}
						System.out.println("ya no quedan estudiantes por calificar.\n");
					}
				} else {
					System.out.println("\nLa cedula del docente no es correcta.\n");
				}
			}
		}
		if (bool == false) {
			System.out.println("\nEl curso '" + aux + "' no existe.\n");
		}

	}

	public String toString() {
		return "Calificar Estudiantes";
	}

}