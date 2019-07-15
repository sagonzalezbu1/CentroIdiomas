package gestorAplicacion.Centro;

import gestorAplicacion.Usuarios.*;

public class Certificado {
	final private String nombre;
	final private Estudiante alumno;
	final private float nota;
	final private Docente docente;

	public Certificado(String name, Estudiante alumno, Docente docente, float nota) {
		nombre = name;
		this.alumno = alumno;
		this.docente = docente;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Estudiante getAlumno() {
		return alumno;
	}
	
	public Docente getDocente() {
		return docente;
	}
	public float getNota() {
		return nota;
	}
	

	public String toString() {
		return "El estudiante " + alumno + " ha aprobado el curso de " + nombre + " con una nota de " + nota
				+ " con el profesor " + docente.getNombre();
	}

}
