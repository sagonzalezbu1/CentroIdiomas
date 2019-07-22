package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

import java.util.Scanner;

public class Matricular extends OpcionDeMenu {
	private String nombre = "Matricular";

	public String getNombre() {
		return nombre;
	}

	public void ejecutar() {

		Scanner e = new Scanner(System.in);
		// Se verifica qu� tipo de usuario hace la matr�cula
		if (Main.user instanceof Estudiante) {
			// Si es estudiante lo matricula normal
			System.out.println("Ingrese el nombre del curso: ");
			String nombre = e.next();
			boolean b = false;
			Curso curso = null;
			for (Curso x : Archivo.getCursos()) {
				if (x.getNombreCurso().equals(nombre)) {
					b = true;
					curso = x;
					break;
				}
			}
			// Luego se verifica que el curso en el que se quiere matricular exista
			if (b == false) {
				System.out.println("\nEl curso '" +nombre+"' No se encontr�.\n");
			} else {
				boolean bool = false;
				boolean aux1 = false;
				// Se verifica si el curso est� vac�o
				if (!curso.getEstudiantes().isEmpty()) {
					for (Estudiante y : curso.getEstudiantes()) {
						// Se verifica si el estudiante ya est� en el curso
						if (Main.user.equals(y)) {
							// S� est�
							System.out.println("Usted ya se encuentra matriculado en este curso.");
							aux1 = false;
							break;
						} else {
							// No est�
							aux1 = true;
						}
					}
					if (aux1 == true) {
						bool = curso.matricular((Estudiante) (Main.user));
						// Por �ltimo se verifica que haya cupos disponibles
						if (bool == true) {
							System.out.println("\nUsted qued� matriculado.\n");
						} else {
							System.out.println("\nNo hay cupos disponibles en este curso.\n");
						}
					}
				} else {
					bool = curso.matricular((Estudiante) (Main.user));
					// Por �ltimo se verifica que haya cupos disponibles

					System.out.println("\nUsted qued� matriculado.\n");

				}
				
			}
		} else {
			// Si es otro, pregunta qu� estudiante matricular
			System.out.println("Ingrese la cedula del estudiante a matricular: ");
			long cedula = e.nextLong();
			boolean b = false;
			Estudiante estudiante = null;
			// Se verifica que el estudiante exista
			for (Estudiante x : Archivo.getEstudiantes()) {
				if (x.getCedula() == cedula) {
					b = true;
					estudiante = x;
					break;
				}
			}
			if (b == true) {
				System.out.println("Ingrese el nombre del curso donde lo quiere matricular: ");
				String nombre = e.next();
				boolean c = false;
				Curso curso = null;
				// Se verifica que el curso exista
				for (Curso x : Archivo.getCursos()) {
					if (x.getNombreCurso().equals(nombre)) {
						c = true;
						curso = x;
						break;
					}
				}
				if (c == false) {
					System.out.println("\nEl curso '" +nombre+"' No se encontr�.\n");
				} else {
					boolean bool = curso.matricular((Estudiante) (estudiante));
					if (bool == true) {
						System.out.println("\nEl estudiante qued� matriculado.\n");
					} else {
						System.out.println("\nNo hay cupos disponibles en este curso.\n");
					}
				}
			} else {
				System.out.println("\nNo se encontr� el estudiante.\n");
			}
		}
	}

	public String toString() {
		return "Matricular";
	}
}