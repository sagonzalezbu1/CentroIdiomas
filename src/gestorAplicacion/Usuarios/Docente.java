package gestorAplicacion.Usuarios;

import java.util.*;
import uiMain.*;
import gestorAplicacion.Centro.*;

public class Docente extends Usuario implements Horario {
	private ArrayList<Curso> misCursos = new ArrayList<>();
	private static final String codigo = "0000";

	public static String getCodigo() {
		return codigo;
	}

	// Constructor para creacion de objeto
	public Docente(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		// Menu por defecto
		getMenu().anadirOpcion(Main.funcionalidades.get("Calificar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerHorario"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerDocentes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerEstudiantesCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("HacerSugerencia"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerSugerencias"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));
		Archivo.add(this);

	}

	// Constructor para carga de archivos
	public Docente(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		// Menu editado
	}

	// Añadir curso a la lista de cursos profesor
	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	// Horario de clases del docente
	public String miHorario() {
		String aux = "";
		for (Curso x : misCursos) {
			aux += "\nNombre: " + x.getNombreCurso() + "\n" + "Horario: " + x.getHorarioCurso();
			aux +="\n";
		}
		if (aux.equals("")) {
			return "\nNo está dictando ningun curso.\n";
		} else {
			return aux;
		}
	}

	// Borrar curso de la lista de cursos del docente
	public void removeCurso(String nombreCurso) {
		Curso y = null;
		for (Curso x : misCursos) {
			if (x.getNombreCurso().equals(nombreCurso)) {
				y = x;
			}
		}
		misCursos.remove(y);
	}

	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

}