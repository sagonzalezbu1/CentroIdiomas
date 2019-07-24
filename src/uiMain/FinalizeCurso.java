package uiMain;

import java.util.Scanner;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por Administrativo para finalizar los cursos, algo as�
 * como cerrar el per�odo de calificaciones al acabar el curso.
 * 
 * En esta clase se ejecuta el m�todo finalizeCurso localizado en la clase Curso.*/
public class FinalizeCurso extends OpcionDeMenu {
	private String nombre="FinalizeCurso";
	/*Getter del nombre, retorna un String correspondiente a su atributo nombre.
	No recibe ning�n par�metro*/
	public String getNombre() {
		return nombre;
	}
	/*Se verifica que los datos para la ejecuci�n del m�todo sean correctos, 
	 * luego se busca el curso, si se encuentra se cierra el per�odo de 
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
			System.out.println("\nNo se encontr� el curso\n");
		} else {
			curso.finalizeCurso();
			System.out.println("\nEl curso ha sido finalizado.\n");
		}
	}

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Finalizar curso";
	}
}