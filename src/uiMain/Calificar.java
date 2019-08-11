package uiMain;

import java.util.*;

import BaseDatos.Archivo;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por el Docente para calificar a los estudiantes de 
 * un cierto curso que esté dictando.
 * 
 * En esta clase se ejecuta el método calificar localizado en la clase Estudiante.*/
public class Calificar extends OpcionDeMenu {
	private String nombre = "Calificar";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}

	/*Se hacen las respectivas verificaciones antes de calificar al estudiante,
	 * como buscar que el estudiante y el curso existan, y luego se ejecuta propiamente*/
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Introduzca el nombre del grupo al que desea calificar: ");
		String cursocalificar = entry.next();
		boolean existenciacurso = false;

		for (Curso curso : Archivo.getCursos()) {
			
			if (curso.getNombreCurso().equals(cursocalificar)) {
				existenciacurso = true;
				System.out.println("Introduzca la cedula del docente que da el curso: ");
				long ccdocente = entry.nextLong();
				if (ccdocente == curso.getDocente().getCedula()) {
					
					if (curso.getEstudiantes().size() == 0) {
						System.out.println("\nEste curso no tiene estudiantes inscritos.\n");
					} 
					else {
						
						for (Estudiante estudiante : curso.getEstudiantes()) {
							long id = estudiante.getCedula();
							System.out.println("Ingrese la nota del estudiante con ID " + id + " (si la nota es un float escribirla con coma): ");
							float calificacion = entry.nextFloat();
							
							while(calificacion<0 || calificacion>5) {
								System.out.println("Ingrese una nota valida: ");
								calificacion = entry.nextFloat();
							}
							
							System.out.println("");
							estudiante.calificar(cursocalificar, calificacion);
						}
						
						System.out.println("Ya no quedan estudiantes por calificar.\n");
						
					}
					
				} else {
					System.out.println("\nLa cedula del docente no es correcta.\n");
				}
				
			}
			
		}
		
		if (existenciacurso == false) {
			System.out.println("\nEl curso '" + cursocalificar + "' no existe.\n");
		}
	}

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Calificar Estudiantes";
	}
}