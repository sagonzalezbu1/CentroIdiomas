package modelo.Centro;

import java.util.*;
import BaseDatos.*;
import modelo.Usuarios.*;
import modelo.excepciones.*;

/*Esta clase permite crear objetos de tipo solicitud. Las solicitudes se hacen con la finalidad de que un estudiante solicite cupo para un tipo de curso,
  Se puede solicitar cupo en un curso de cualquier tipo de idioma, siempre y cuando no queden cupos o no haya cursos creados de dicho idioma*/
public class Solicitud {
	
	static private HashMap<String, ArrayList<Solicitud>> solicitudes = new HashMap<String, ArrayList<Solicitud>>();
	
	private Estudiante estu;
	private String tipo;

	/*
	 * Constructor de solicitud. Las solicitudes tienen al estudiante que la realiza
	 * y un String que contiene el tipo de curso al cual solicita el estudiante.
	 * Cuando se crea una solicitud esta inmediatamente se añade a la lista
	 * correspondiente del hashmap de archivo, si esa lista aun no existe, se crea
	 * automaticamente antes de agregar la solicitud
	 */
	public Solicitud(String tipo, Estudiante estudiante) {
		this.tipo = tipo;
		estu = estudiante;

		if (Solicitud.getSolicitudes().containsKey(tipo)) {
			(Solicitud.getSolicitudes().get(tipo)).add(this);
		} else {
			Solicitud.getSolicitudes().put(tipo, new ArrayList<>());
			(Solicitud.getSolicitudes().get(tipo)).add(this);
		}
	}

	public String aceptarSolicitud() throws NoHayDisponibilidad {
		{
			Curso course = Archivo.cursoDisponibilidad(tipo);
			if (course == null) {
				throw new NoHayDisponibilidad();
			} else {
				course.matricular(this.getEstudiante());
				Solicitud.removeSolicitud(tipo, this);
				(this.getEstudiante()).removeSolicitud(tipo);
				return "Solicitud Acetada";
			}
		}
	}

	public String rechazarSolicitud() {
		Solicitud.removeSolicitud(tipo, this);
		(this.getEstudiante()).removeSolicitud(tipo);
		return "Solicitud Rechazada";
	}

	// Metodo que retorna al estudiante que hizo la solicitud. No recibe ningun
	// parametro
	public Estudiante getEstudiante() {
		return estu;
	}

	// Metodo que retorna un String que contiene el tipo de la solicitud. No recibe
	// ningun parametro
	public String getTipo() {
		return tipo;
	}

	// Metodo toString. Retorna un String con formato correcto que contiene el tipo
	// de la solicitud. No recibe ningun parametro.
	public String toString() {
		return tipo;
	}
	
	static public String verSolicitudes() {
		String ver = "";

		for (String x : solicitudes.keySet()) {
			ver += x + "\n";
		}

		if (!ver.equals("")) {
			return "\nSolicitudes:\n" + ver;
		} else {
			return "No hay solicitudes.";
		}
	}
	static public void removeSolicitud(String tipo, Solicitud s) {
		(solicitudes.get(tipo)).remove(s);
		if (solicitudes.get(tipo).isEmpty()) {
			solicitudes.remove(tipo);
		}
	}
	static public HashMap<String, ArrayList<Solicitud>> getSolicitudes() {
		return solicitudes;
	}
}