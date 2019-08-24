package modelo.Usuarios;

import java.util.*;

import BaseDatos.Archivo;
import control.*;
import modelo.Centro.*;

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
		getProcesos().add(Main.funcionalidades.get("Calificar"));
		getProcesos().add(Main.funcionalidades.get("VerHorario"));
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add(Main.funcionalidades.get("VerDocentes"));
		getProcesos().add(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getProcesos().add(Main.funcionalidades.get("VerEstudiantesCurso"));
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("VerSugerencias"));
		getProcesos().add(Main.funcionalidades.get("PromedioCurso"));
		getProcesos().add(Main.funcionalidades.get("CerrarSesion"));
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