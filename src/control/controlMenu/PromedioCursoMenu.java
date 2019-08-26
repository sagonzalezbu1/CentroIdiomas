package control.controlMenu;

import java.text.DecimalFormat;
import java.util.*;
import BaseDatos.Archivo;
import control.OpcionDeMenu;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Administrativo y Docente para ver el promedio de las notas de 
 * los estudiantes de cierto curso.*/
public class PromedioCursoMenu extends OpcionDeMenu {
	private String nombre = "PromedioCurso";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}
	/*Se hacen verificaciones básicas antes de calcular el promedio.
	 * Para ello se suman las notas acumuladas y se dividen entre el total de estudiantes*/
	public void ejecutar() {
		Scanner entry= new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombrec= entry.next();
		Curso course= Archivo.buscarCurso(nombrec);
		
		if (course!=null) {
			
			if (course.getEstudiantes().isEmpty()) {
				System.out.println("\nNo hay estudiantes inscritos.\n");
			} else {
				double prom = 0;
				
				for (Estudiante estudiante: course.getEstudiantes()) {
					prom += estudiante.getDefinitiva(nombrec);
				}
				
				prom = prom/(course.getEstudiantes()).size();
				DecimalFormat f = new DecimalFormat("#.00"); 
				System.out.println("\nEl promedio del curso es: "+ f.format(prom) +"\n");
			}
			
		} else {
			System.out.println("\nEl curso no existe.\n");
		}
	}

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Promedio de un curso";
	}
}