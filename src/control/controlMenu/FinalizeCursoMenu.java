package control.controlMenu;

import java.util.Scanner;

import BaseDatos.Archivo;
import control.OpcionDeMenu;
import modelo.Centro.*;
import modelo.Usuarios.*;
import modelo.excepciones.noHayNotas;

/*Esta clase es usada por Administrativo para finalizar los cursos, algo así
 * como cerrar el período de calificaciones al acabar el curso.
 * 
 * En esta clase se ejecuta el método finalizeCurso localizado en la clase Curso.*/
public class FinalizeCursoMenu extends OpcionDeMenu {
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
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso que desea finalizar: ");
		String nombre = entry.next();
		Curso cursofinalizar = null;
		
		for (Curso curso : Archivo.getCursos()) {
			if (curso.getNombreCurso().equals(nombre)) {
				cursofinalizar = curso;
				break;
			}
		}
		
		if (cursofinalizar == null) {
			System.out.println("\nNo se encontró el curso\n");
		} else {
			cursofinalizar.finalizeCurso();
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