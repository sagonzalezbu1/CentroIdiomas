package gestorAplicacion.Centro;

import gestorAplicacion.Usuarios.*;

/*Esta clase permite crear objetos de tipo certificado para otorgarselos a un estudiante. Los certificados son la constancia de que un estudiante aprobo
  un curso con una nota mayor o igual a 3.0. Los certificados contienen al alumno, el tipo de curso que aprobo, la nota con la que lo aprobo y el docente con el 
  cual vio el curso*/
public class Certificado {
	final private String nombre;
	final private Estudiante alumno;
	final private float nota;
	final private Docente docente;
    
	/*Constructor de certificado, Recibe: un String que corresponde al tipo de curso que aprobó (ingles,frances...etc), el estudiante que aprobo el curso,
	  el docente que daba el curso cuando fue aprobado por el estudiante y un float que corresponde a la nota con la cual aprobó el estudiante)
	 */
	public Certificado(String name, Estudiante alumno, Docente docente, float nota) {
		nombre = name;
		this.alumno = alumno;
		this.docente = docente;
		this.nota = nota;
	}

	//Metodo que retorna un String que contiene el tipo de curso al cual corresponde el certificado (ingles,frances,etc). No recibe ningun parametro
	public String getNombre() {
		return nombre;
	}
	//Metodo que retorna el estudiante que aprobo el curso al cual corrresponde el certificado. No recibe ningun parametro
	public Estudiante getAlumno() {
		return alumno;
	}
	//Metodo que retorna el docente que dicataba el curso en el momento en el que el estudiante lo aprobo. No recibe ningun parametro
	public Docente getDocente() {
		return docente;
	}
	//Metodo que retorna un Float, correspondiente a la nota con la que el estudiante aprobo el curso. No recibe ningun parametro
	public float getNota() {
		return nota;
	}
	

	/*Metodo toString. Retorna un String con formato correcto que contiene al estudiante que aprobo el curso,  el docente que daba el curso cuando fue
	  aprobado por el estudiante y un float que corresponde a la nota con la cual aprobó el estudiante. No recibe ningun parametro*/
	public String toString() {
		return "El estudiante " + alumno.getNombre() + " con cédula " + alumno.getCedula() + ", ha aprobado el curso de " + nombre + " con una nota de " + nota
				+ " con el profesor " + docente.getNombre() + ".";
	}

}
