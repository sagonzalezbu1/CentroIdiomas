package control;

import java.util.*;

import BaseDatos.Archivo;
import modelo.Centro.*;
import modelo.Usuarios.*;

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
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el nombre del curso: ");
		String nombre = entry.next();
		System.out.println("Ingrese el horario del curso (dia1-dia2_horainicio-horafinal): ");
		String horario = entry.next();
		System.out.println("Ingrese la cedula del docente que dar� el curso: ");
		long cc = entry.nextLong();
		Docente docente=null;
		boolean existenciadocente = false;
		
		for(Docente doc : Archivo.getDocentes()) {
			if(cc==doc.getCedula()) {
				existenciadocente=true;
				docente=doc;
			}
		}
		
		if(existenciadocente==true) {
			System.out.println("Ingrese el tipo del curso(ingles, aleman, mandarin,...): "); 
			String tipo = entry.next(); 
			Curso existenciacurso= Archivo.buscarCurso(nombre);
			
			if(existenciacurso==null) {
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