package gestorAplicacion.Usuarios;

import java.util.*;

import BaseDatos.Archivo;
import uiMain.*;
import gestorAplicacion.Centro.*;

/*Esta clase permite crear objetos de tipo Docente, los cuales cumplirán tareas como
 * calificar a los estudiantes de los cursos que estén dictando*/
public class Docente extends Usuario implements Horario {
	//Lista de los cursos que dicta el docente
	private ArrayList<Curso> misCursos = new ArrayList<>();
	//Para poder registrarse como Docente se necesita un código especial
	private static final String codigo = "0000";
	//Retorna el código especial para registrarse. No recibe parámetros
	public static String getCodigo() {
		return codigo;
	}

	//Constructor usado en la creación de objetos de tipo Docente desde el programa
	public Docente(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		//Se crea el menu de Docente con las funcionalidades por defecto
		getMenu().anadirOpcion(Main.funcionalidades.get("Calificar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerHorario"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerDocentes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerEstudiantesCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("HacerSugerencia"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerSugerencias"));
		getMenu().anadirOpcion(Main.funcionalidades.get("PromedioCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));
		Archivo.add(this);

	}

	/*Constructor usado en la creación de objetos de tipo Docente desde la carga de 
	 * los archivos de texto al programa*/
	public Docente(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		/*Aquí tendrá el menu ya sea por defecto o editado, 
		* dependiendo de si el administrador lo haya editado*/
	}

	/*Añade un curso a la lista de cursos del docente, recibe como 
	* parámetro un Curso y no retorna nada*/
	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	/*Retorna el horario de los cursos que dicta el docente, 
	 * buscándolos en la lista de cada uno. No recibe parámetros*/
	public String miHorario() {
		String aux = "";
		for (Curso curso : misCursos) {
			aux += "\nNombre: " + curso.getNombreCurso() + "\n" + "Horario: " + curso.getHorarioCurso();
			aux +="\n";
		}
		if (aux.equals("")) {
			return "\nNo está dictando ningun curso.\n";
		} else {
			return aux;
		}
	}

	/*Borra un curso de la lista de cursos del docente, buscándolo en la lista de cada uno.
	 * No recibe parámetros y no retorna nada*/
	public void removeCurso(String nombreCurso) {
		Curso y = null;
		for (Curso curso : misCursos) {
			if (curso.getNombreCurso().equals(nombreCurso)) {
				y = curso;
			}
		}
		misCursos.remove(y);
	}
	
	/*Retorna la información del docente de manera correcta, mostrando su nombre y cédula.
	 * No recibe parámetros*/
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

}