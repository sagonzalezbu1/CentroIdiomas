package gestorAplicacion.usuarios;

import java.util.*;
import gestorAplicacion.Centro.*;
import uiMain.*;

public class Docente extends Usuario {
	private ArrayList<Curso> misCursos;
	private static final String codigo = "0000";

	public static String getCodigo() {
		return codigo;
	}

	public Docente(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(cedula, clave);
		Archivo.add(this);
	}

	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	public String miHorario() {
		String aux = "";
		for (Curso x : misCursos) {
			aux += "Nombre: " + x.getNombreCurso() + "\n" + "Horario: " + x.getHorarioCurso() + "\n";
			aux += "\n";
		}
		return aux;
	}

	public void removeCurso(String nombreCurso) {
		for (Curso x : misCursos) {
			if (x.getNombreCurso().equals(nombreCurso)) {
				misCursos.remove(x);
			}
		}
	}

	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

}