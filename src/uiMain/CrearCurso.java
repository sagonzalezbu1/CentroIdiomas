package uiMain;

import java.util.*;

import BaseDatos.Archivo;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por el Administrativo para crear nuevos cursos para los estudiantes.
 * 
 * En esta clase se crean objetos de tipo Curso y se les asignan sus respectivos atributos.*/
public class CrearCurso extends OpcionDeMenu {
	private String nombre="CrearCurso";
	public String getNombre() {
		return nombre;
	}
	/*Se hacen verificaciones antes de crear el curso, tales como que �ste no exista ya, 
	 * que la informaci�n ingresada sea correcta, entre otras cosas, para luego crearlo*/
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombre = e.next();
		System.out.println("Ingrese el horario del curso (dia1-dia2_horainicio-horafinal): ");
		String horario = e.next();
		System.out.println("Ingrese la cedula del docente que dar� el curso: ");
		long cc = e.nextLong();
		Docente docente=null;
		boolean b = false;
		for(Docente x : Archivo.getDocentes()) {
			if(cc==x.getCedula()) {
				b=true;
				docente=x;
			}
		}
		if(b==true) {
			System.out.println("Ingrese el tipo del curso(ingles, aleman, mandarin,...): "); 
			String tipo = e.next(); 
			Curso busqueda= Archivo.buscarCurso(nombre);
			if(busqueda==null) {
				new Curso(nombre,tipo,horario,docente);
				System.out.println("\nSe ha creado el curso.\n");
			} else {
				System.out.println("\nYa existe un curso con ese nombre.\n");
			}
		}
		else {
			System.out.println("\nEl docente no existe.\n");
		}
	}

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Crear Curso";
	}
}