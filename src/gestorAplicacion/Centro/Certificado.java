package gestorAplicacion.Centro;

import gestorAplicacion.Usuarios.*;

public class Certificado {
	final private String nombre;
	final private String alumno;
	final private float nota;
	final private Docente docente;

	Certificado(String name, String alumno, Docente docente, float nota) {
		nombre = name;
		this.alumno = alumno;
		this.docente = docente;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return "El estudiante " + alumno + " ha aprobado el curso de " + nombre + " con una nota de " + nota
				+ " con el profesor " + docente.getNombre();
	}

}
