package control;

import java.util.*;

import BaseDatos.Archivo;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Estudiante para inscribirse a los cursos disponibles.
 * 
 * En esta clase se ejecuta el m�todo matricular localizado en la clase Curso.*/
public class Matricular extends OpcionDeMenu {
	private String nombre = "Matricular";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro*/
	public String getNombre() {
		return nombre;
	}
	/*Se hacen verificaciones antes de matricular al estudiante*/
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		
		if (Main.user instanceof Estudiante) {
			System.out.println("Ingrese el nombre del curso: ");
			String nombre = entry.next();
			Curso curso = Archivo.buscarCurso(nombre);
			
			//Se verifica que el curso en el que se va a matricular exista
			if (curso == null) {
				System.out.println("\nEl curso '" + nombre + "' No se encontr�.\n");
			} else {
				
				//Se verifica que el estudiante no haya aprobado un curso de ese tipo
				for (Certificado certificado : ((Estudiante) (Main.user)).getCertificados()) {
					if ((certificado.getNombre()).equals(curso.getTipo())) {
						System.out.println("\nUsted ya aprobo una curso de este tipo.\n");
						return;
					}
				}
				
				//Verfica que no tenga solicitudes de ese tipo
				for (Solicitud solicitud : ((Estudiante) (Main.user)).getSolicitudes()) {
					if ((solicitud.getTipo()).equals(curso.getTipo())) {
						System.out.println("\nUsted ya tiene una solicitud de este tipo.\n");
						return;
					}
				}
				
				if (!curso.getEstudiantes().isEmpty()) {
					
					for (Estudiante estudiante : curso.getEstudiantes()) {
						// Se verifica si el estudiante ya est� en el curso
						if (Main.user.equals(estudiante)) {
							System.out.println("\nUsted ya se encuentra matriculado en este curso.\n");
							return;
						}
					}
					
					if (curso.getCuposDisponibles() > 0) {
						curso.matricular((Estudiante) (Main.user));
						System.out.println("\nUsted qued� matriculado.\n");
					} else {
						System.out.println("\nNo hay cupos disponibles en este curso.\n");
					}
					
				} else {
					curso.matricular((Estudiante) (Main.user));
					System.out.println("\nUsted qued� matriculado.\n");
				}
			}
		} else {
			/*Si es un usuario diferente de Estudiante, pregunta qu� estudiante 
			matricular y sigue los mismos pasos de antes*/
			System.out.println("Ingrese la cedula del estudiante a matricular: ");
			long cedula = entry.nextLong();
			Estudiante est = Archivo.buscarEstudiante(cedula);
			// Se verifica que el estudiante exista
			if (est != null) {
				System.out.println("Ingrese el nombre del curso: ");
				String nombre = entry.next();
				Curso curso = Archivo.buscarCurso(nombre);
				
				//Se verifica que el curso en el que se va a matricular exista
				if (curso == null) {
					System.out.println("\nEl curso '" + nombre + "' No se encontr�.\n");
				} else {
					
					//Verifica que no haya aprobado un curso de ese tipo
					for (Certificado certificado : est.getCertificados()) {
						if ((certificado.getNombre()).equals(curso.getTipo())) {
							System.out.println("\nUsted ya aprobo una curso de este tipo.\n");
							return;
						}
					}
					
					//Verfica que no tenga solicitudes de ese tipo
					for (Solicitud solicitud : est.getSolicitudes()) {
						if ((solicitud.getTipo()).equals(curso.getTipo())) {
							System.out.println("\nUsted ya tiene una solicitud de este tipo.\n");
							return;
						}
					}
					
					// Se verifica si el curso no est� vac�o
					if (!curso.getEstudiantes().isEmpty()) {
						
						for (Estudiante estudiante : curso.getEstudiantes()) {
							// Se verifica si el estudiante ya est� en el curso
							if (est.equals(estudiante)) {
								System.out.println("\nEl estudiante ya se encuentra matriculado en este curso.\n");
								return;
							}
						}
						
						if (curso.getCuposDisponibles() > 0) {
							curso.matricular(est);
							System.out.println("\nEl estudiante qued� matriculado.\n");
						} else {
							System.out.println("\nNo hay cupos disponibles en este curso.\n");
						}
						
					} else {
						curso.matricular(est);
						System.out.println("\nEl estudiante qued� matriculado.\n");
					}
				}
				
			} else {
				System.out.println("\nNo se encontr� el estudiante.\n");
			}
		}
	}

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Matricular";
	}
}