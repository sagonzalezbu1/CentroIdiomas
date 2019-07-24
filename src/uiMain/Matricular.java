package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

/*Esta clase es usada por Estudiante para inscribirse a los cursos disponibles.
 * 
 * En esta clase se ejecuta el método matricular localizado en la clase Curso.*/
public class Matricular extends OpcionDeMenu {
	private String nombre = "Matricular";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}
	/*Se hacen verificaciones antes de matricular al estudiante*/
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		if (Main.user instanceof Estudiante) {
			System.out.println("Ingrese el nombre del curso: ");
			String nombre = e.next();
			Curso curso = Archivo.buscarCurso(nombre);
			//Se verifica que el curso en el que se va a matricular exista
			if (curso == null) {
				System.out.println("\nEl curso '" + nombre + "' No se encontró.\n");
			} else {
				//Se verifica que el estudiante no haya aprobado un curso de ese tipo
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
				if (!curso.getEstudiantes().isEmpty()) {
					for (Estudiante y : curso.getEstudiantes()) {
						// Se verifica si el estudiante ya está en el curso
						if (Main.user.equals(y)) {
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
			/*Si es un usuario diferente de Estudiante, pregunta qué estudiante 
			matricular y sigue los mismos pasos de antes*/
			System.out.println("Ingrese la cedula del estudiante a matricular: ");
			long cedula = e.nextLong();
			Estudiante est = Archivo.buscarEstudiante(cedula);
			// Se verifica que el estudiante exista
			if (est != null) {
				System.out.println("Ingrese el nombre del curso: ");
				String nombre = e.next();
				Curso curso = Archivo.buscarCurso(nombre);
				//Se verifica que el curso en el que se va a matricular exista
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
					// Se verifica si el curso no está vacío
					if (!curso.getEstudiantes().isEmpty()) {
						for (Estudiante y : curso.getEstudiantes()) {
							// Se verifica si el estudiante ya está en el curso
							if (est.equals(y)) {
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

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Matricular";
	}
}