package uiMain;

import java.util.Scanner;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Administrativo para finalizar los cursos, algo así
 * como cerrar el período de calificaciones al acabar el curso.
 * 
 * En esta clase se ejecuta el método finalizeCurso localizado en la clase Curso.*/
public class FinalizeCurso extends OpcionDeMenu {
	private String nombre="FinalizeCurso";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ningún parámetro*/
	public String getNombre() {
		return nombre;
	}
	/*Se verifica que los datos para la ejecución del método sean correctos, 
	 * luego se busca el curso, si se encuentra se cierra el período de 
	 * calificaciones de este*/
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso que desea finalizar: ");
		String nombre = e.next();
		Curso curso = null;
		for (Curso x : Archivo.getCursos()) {
			if (x.getNombreCurso().equals(nombre)) {
				curso = x;
				break;
			}
		}
		if (curso == null) {
			System.out.println("\nNo se encontró el curso\n");
		} else {
			curso.finalizeCurso();
			System.out.println("\nEl curso ha sido finalizado.\n");
		}
	}

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Finalizar curso";
	}
}