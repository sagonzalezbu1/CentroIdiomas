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
		// Se verifica qué tipo de usuario hace la matrícula
		if (Main.user instanceof Estudiante) {
			// Si es estudiante lo matricula normal
			System.out.println("Ingrese el nombre del curso: ");
			String nombre = e.next();
			Curso curso = Archivo.buscarCurso(nombre);
			// Luego se verifica que el curso en el que se quiere matricular exista
			if (curso == null) {
				System.out.println("\nEl curso '" + nombre + "' No se encontró.\n");
			} else {
				//Verifica que no haya aprobado un curso de ese tipo
				for (Certificado x : ((Estudiante) (Main.user)).getCertificados()) {
					if ((x.getNombre()).equals(curso.getTipo())) {
						System.out.println("\nUsted ya aprobo una curso de este tipo.\n");
						return;
					}
				}
				//Verfica que no tenga solicitudes de ese tipo
				for (Solicitud x : ((Estudiante) (Main.user)).getSolicitudes()) {
					if ((x.getTipo()).equals(curso.getTipo())) {
						System.out.println("\nUsted ya tiene una solicitud de este tipo.\n");
						return;
					}
				}
				// Se verifica si el curso está vacío
				if (!curso.getEstudiantes().isEmpty()) {
					for (Estudiante y : curso.getEstudiantes()) {
						// Se verifica si el estudiante ya está en el curso
						if (Main.user.equals(y)) {
							// Sí está
							System.out.println("\nUsted ya se encuentra matriculado en este curso.\n");
							return;
						}
					}
					if (curso.getCuposDisponibles() > 0) {
						curso.matricular((Estudiante) (Main.user));
						System.out.println("\nUsted quedó matriculado.\n");
					} else {
						System.out.println("\nNo hay cupos disponibles en este curso.\n");
					}
				} else {
					curso.matricular((Estudiante) (Main.user));
					System.out.println("\nUsted quedó matriculado.\n");
				}
			}
		} else {
			// Si es otro, pregunta qué estudiante matricular
			System.out.println("Ingrese la cedula del estudiante a matricular: ");
			long cedula = e.nextLong();
			Estudiante est = Archivo.buscarEstudiante(cedula);
			// Se verifica que el estudiante exista
			if (est != null) {
				System.out.println("Ingrese el nombre del curso: ");
				String nombre = e.next();
				Curso curso = Archivo.buscarCurso(nombre);
				// Luego se verifica que el curso en el que se quiere matricular
				// exista
				if (curso == null) {
					System.out.println("\nEl curso '" + nombre + "' No se encontró.\n");
				} else {
					//Verifica que no haya aprobado un curso de ese tipo
					for (Certificado x : est.getCertificados()) {
						if ((x.getNombre()).equals(curso.getTipo())) {
							System.out.println("\nUsted ya aprobo una curso de este tipo.\n");
							return;
						}
					}
					//Verfica que no tenga solicitudes de ese tipo
					for (Solicitud x : est.getSolicitudes()) {
						if ((x.getTipo()).equals(curso.getTipo())) {
							System.out.println("\nUsted ya tiene una solicitud de este tipo.\n");
							return;
						}
					}
					// Se verifica si el curso está vacío
					if (!curso.getEstudiantes().isEmpty()) {
						for (Estudiante y : curso.getEstudiantes()) {
							// Se verifica si el estudiante ya está en el curso
							if (est.equals(y)) {
								// Sí está
								System.out.println("\nEl estudiante ya se encuentra matriculado en este curso.\n");
								return;
							}
						}
						if (curso.getCuposDisponibles() > 0) {
							curso.matricular(est);
							System.out.println("\nEl estudiante quedó matriculado.\n");
						} else {
							System.out.println("\nNo hay cupos disponibles en este curso.\n");
						}
					} else {
						curso.matricular(est);
						System.out.println("\nEl estudiante quedó matriculado.\n");
					}
				}
			} else {
				System.out.println("\nNo se encontró el estudiante.\n");
			}
		}
	}

	public String toString() {
		return "Matricular";
	}
}