package gestorAplicacion.Usuarios;

import java.util.*;

import BaseDatos.Archivo;
import uiMain.*;
import gestorAplicacion.Centro.*;

/*Esta clase permite crear objetos de tipo Docente, los cuales cumplir�n tareas como
 * calificar a los estudiantes de los cursos que est�n dictando*/
public class Docente extends Usuario implements Horario {
	//Lista de los cursos que dicta el docente
	private ArrayList<Curso> misCursos = new ArrayList<>();
	//Para poder registrarse como Docente se necesita un c�digo especial
	private static final String codigo = "0000";
	//Retorna el c�digo especial para registrarse. No recibe par�metros
	public static String getCodigo() {
		return codigo;
	}

	//Constructor usado en la creaci�n de objetos de tipo Docente desde el programa
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

	/*Constructor usado en la creaci�n de objetos de tipo Docente desde la carga de 
	 * los archivos de texto al programa*/
	public Docente(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		/*Aqu� tendr� el menu ya sea por defecto o editado, 
		* dependiendo de si el administrador lo haya editado*/
	}

	/*A�ade un curso a la lista de cursos del docente, recibe como 
	* par�metro un Curso y no retorna nada*/
	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	/*Retorna el horario de los cursos que dicta el docente, 
	 * busc�ndolos en la lista de cada uno. No recibe par�metros*/
	public String miHorario() {
		String aux = "";
		for (Curso curso : misCursos) {
			aux += "\nNombre: " + curso.getNombreCurso() + "\n" + "Horario: " + curso.getHorarioCurso();
			aux +="\n";
		}
		if (aux.equals("")) {
			return "\nNo est� dictando ningun curso.\n";
		} else {
			return aux;
		}
	}

	/*Borra un curso de la lista de cursos del docente, busc�ndolo en la lista de cada uno.
	 * No recibe par�metros y no retorna nada*/
	public void removeCurso(String nombreCurso) {
		Curso y = null;
		for (Curso curso : misCursos) {
			if (curso.getNombreCurso().equals(nombreCurso)) {
				y = curso;
			}
		}
		misCursos.remove(y);
	}
	
	/*Retorna la informaci�n del docente de manera correcta, mostrando su nombre y c�dula.
	 * No recibe par�metros*/
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

}