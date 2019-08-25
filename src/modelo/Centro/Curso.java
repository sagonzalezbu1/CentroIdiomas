package modelo.Centro;

import java.util.*;
import BaseDatos.Archivo;
import modelo.Usuarios.*;
import modelo.excepciones.*;

/*Esta clase permite crear objetos de tipo curso. Los cursos pueden ser de cualquier idioma y tienen un maximo de 10 cupos por curso. Son parte importante
  del centro de idiomas pues contienen a los estudiantes, y si aprueban o no el curso es lo que les otorga a los estudiantes el certificado del idioma */
public class Curso {
	final String nombre;
	private String tipo;
	private String horario;
	private Docente docente;
	private int cupos = 10;
	private ArrayList<Estudiante> alumnos = new ArrayList<Estudiante>();

	/*Constructor de curso. Los cursos contienen un String que corresponde al nombre del curso, otro String que correspondel al tipo del curso (ingles,frances,etc),
	  otro String que corresponde al horario en el que se dictara este curso y un Docente, que sera el encargado de dictarlo y de calificar estudiantes */
	public Curso(String name, String tipo, String horario, Docente docente) {
		nombre = name;
		this.horario = horario;
		this.docente = docente;
		this.tipo = tipo;
		Archivo.add(this);
		docente.addCurso(this);
	}

	/*Este metodo Finaliza un curso, cierrra el periodo de calificaciones, calcula el promedio de cada estudiante y si es mayor o igual a 3.0 los aprueba
	  y les otorga un certificado. Tambien actualiza el estado del estudiante segun como se encuentre al finalizar el curso (Activo,Inactivo, Egresado)
	  y luego borra todos los apuntadores que tiene el curso para asi borrarlo definitivamente. No retorna nada, ni recibe ningun parametro*/
	public void finalizeCurso() {
		
		while (alumnos.size() > 0) {
			Estudiante estudiante = alumnos.get(0);
			alumnos.remove(0);
			float nota = estudiante.getDefinitiva(nombre);
			
			if (nota >= 3) {
				estudiante.setEstado(nombre, 1);
				estudiante.addCertificado(new Certificado(tipo, estudiante, docente, nota));
			}
			
			estudiante.removeCurso(nombre);
		}
		
		docente.removeCurso(nombre);
		Archivo.removeCurso(nombre);
	}

	//Metodo que retorna un int que indica la cantidad de cupos que tiene un curso. No recibe ningun parametro
	public int getCupos() {
		return cupos;
	}

	//Metodo que retorna un int que indica la cantidad de cupos disponibles que tiene un curso. No recibe ningun parametro
	public int getCuposDisponibles() {
		return cupos - alumnos.size();
	}

	//Metodo que retorna la lista de los estudiantes matriculados en el curso. No recibe ningun parametro
	public ArrayList<Estudiante> getEstudiantes() throws noHayEstudiantes {
		if(!alumnos.isEmpty()) {
			return alumnos;
		}else {
			throw new noHayEstudiantes();
		}
		
	}

	//Metodo que retorna el docente asignado al curso. No recibe ningun parametro
	public Docente getDocente() {
		return docente;
	}

	//Metodo que retorna un String que contiene el horario del curso. No recibe ningun parametro
	public String getHorarioCurso() {
		return horario;
	}

	//Metodo que retorna un String que contiene el nombre del curso. No recibe ningun parametro
	public String getNombreCurso() {
		return nombre;
	}

	//Metodo que retorna un String que contiene el tipo del curso. No recibe ningun parametro
	public String getTipo() {
		return tipo;
	}

	/*Este metodo matricula estudiantes al curso, lo cual se traduce en añadir al estudiante a la lista de estudiantes del curso y añadir el curso en la 
	  lista de cursos del estudiante. Retorna un boolean, cuando es true significa que el estudiante fue matriculado satisfactoriamente, si retorna false
	  es que no se pudo matricular al estudiante por falta de cupos. Recibe como parametro el estudiante al que se desea matricular en el curso.
	 */
	public boolean matricular(Estudiante estudiante) {
		
		if (cupos - alumnos.size() > 0) {
			alumnos.add(estudiante);
			estudiante.addCurso(this);
			estudiante.setEstado(0);
			return true;
		} else {
			return false;
		}
		
	}

	/*Metodo toString. Retorna un String que contiene el nombre del curso, el horario, el nombre del profesor que dicta el curso y los cupos disponibles.
	  No recibe ningun parametro*/
	public String toString() {
		return "Nombre: " + nombre + "\nHorario: " + horario + "\nProfesor: " + docente.getNombre()
				+ "\nCupos disponibles: " + (cupos - alumnos.size());
	}

	/*Permite ver los estudiantes matriculados en el curso. Retorna un String con formato correcto que contiene el nombre y cedula de cada uno de los
	  estudiantes que se encuentran matriculados. No recibe ningun parametro*/
	public String verEstudiantes() {
		String ver = "";
		for (Estudiante estudiante : alumnos) {
			ver += estudiante.toString() + "\n";
		}
		return ver;
	}
	
	/*Metodo que se ejecuta cuando java ejecuta el garbage collections. Indica que el curso ha sido borrado satisfactoriamente. No recibe ningun parametro
	  ni retorna nada*/
	public void finalize() {
		System.out.println("\nEl curso "+nombre+" ha sido borrado del sistema.\n");
	}
	
	public String crearCurso(String nombre, String horario,long docente, String tipo) {
		
		try {
			Curso curso= Archivo.buscarCurso(nombre);
			return "Ya existe un curso con ese nombre.";
		}catch(noExisteCurso excepcion) {
			try {
			Docente docen= Archivo.buscarDocente(docente);
			new Curso(nombre,tipo,horario,docen);
			return "El curso se ha creado exitosamente.";
			}catch(noExisteDocente excecion) {
				return "No existe docente.";
			}
		}
	}
}

