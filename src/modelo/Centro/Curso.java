package modelo.Centro;

import java.text.*;
import java.util.*;
import BaseDatos.*;
import modelo.Usuarios.*;
import modelo.excepciones.*;
import modelo.excepciones.modelo.CursoExistente;
import modelo.excepciones.modelo.CursoYaInscrito;
import modelo.excepciones.modelo.EstudianteConCertificado;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoExisteDocente;
import modelo.excepciones.modelo.NoExisteEstudiante;
import modelo.excepciones.modelo.NoHayCupos;
import modelo.excepciones.modelo.NoHayCursos;
import modelo.excepciones.modelo.NoHayEstudiantes;
import modelo.excepciones.modelo.NoHayNotas;
import modelo.excepciones.modelo.SolicitudYaHecha;

/*Esta clase permite crear objetos de tipo curso. Los cursos pueden ser de cualquier idioma y tienen un maximo de 10 cupos por curso. Son parte importante
  del centro de idiomas pues contienen a los estudiantes, y si aprueban o no el curso es lo que les otorga a los estudiantes el certificado del idioma */
public class Curso {
	
	static private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	
	final String nombre;
	private String tipo;
	private String horario;
	private Docente docente;
	private int cupos = 10;
	private ArrayList<Estudiante> alumnos = new ArrayList<Estudiante>();

	/*
	 * Constructor de curso. Los cursos contienen un String que corresponde al
	 * nombre del curso, otro String que correspondel al tipo del curso
	 * (ingles,frances,etc), otro String que corresponde al horario en el que se
	 * dictara este curso y un Docente, que sera el encargado de dictarlo y de
	 * calificar estudiantes
	 */
	public Curso(String name, String tipo, String horario, Docente docente) {
		nombre = name;
		this.horario = horario;
		this.docente = docente;
		this.tipo = tipo;
		Curso.add(this);
		docente.addCurso(this);
	}
	
	
	/*
	 * Busca si hay un curso con cupos disponibles, como parametro recibe el tipo
	 * del curso, y retornara el primer curso que encuentre con cupos disponibles
	 * del tipo que se le especifico, en caso de no haber cursos disponibles de ese
	 * tipo, retornara null
	 */
	static public Curso cursoDisponibilidad(String tipo) {
		ArrayList<Curso> Cursos = getCursos();
		for (Curso c : Cursos) {
			if (c.getTipo().equals(tipo) && c.getCuposDisponibles() > 0) {
				return c;
			}
		}
		return null;
	}
	
	static public String verEstudiantesCurso(String curso) throws NoExisteCurso, NoHayEstudiantes {

		String ver = "";
		for (Estudiante x : Curso.buscarCurso(curso).getEstudiantes()) {
			ver += x.toString() + "\n";
		}
		return ver;

	}
	
	static public String MatricularEstudiante(long cc, String name) throws NoExisteCurso, NoExisteEstudiante,
			NoHayCupos, CursoYaInscrito, EstudianteConCertificado, SolicitudYaHecha {
		Estudiante est = Estudiante.buscarEstudiante(cc);
		Curso curso = Curso.buscarCurso(name);
		for (Certificado certificado : est.getCertificados()) {
			if ((certificado.getNombre()).equals(curso.getTipo())) {
				throw new EstudianteConCertificado();
			}
		}
		for (Solicitud solicitud : est.getSolicitudes()) {
			if ((solicitud.getTipo()).equals(curso.getTipo())) {
				throw new SolicitudYaHecha();
			}
		}

		try {
			for (Estudiante estudiante : curso.getEstudiantes()) {
				// Se verifica si el estudiante ya está en el curso
				if (est.equals(estudiante)) {
					throw new CursoYaInscrito();
				}
			}
			if (curso.getCuposDisponibles() > 0) {
				curso.matricular(est);
				return ("El estudiante quedó matriculado.");
			} else {
				throw new NoHayCupos();
			}
			
		} catch (NoHayEstudiantes excepcion) {
			curso.matricular(est);
			return ("El estudiante quedó matriculado.");
		}

		
	}

	/*
	 * Este metodo Finaliza un curso, cierrra el periodo de calificaciones, calcula
	 * el promedio de cada estudiante y si es mayor o igual a 3.0 los aprueba y les
	 * otorga un certificado. Tambien actualiza el estado del estudiante segun como
	 * se encuentre al finalizar el curso (Activo,Inactivo, Egresado) y luego borra
	 * todos los apuntadores que tiene el curso para asi borrarlo definitivamente.
	 * No retorna nada, ni recibe ningun parametro
	 */

	static public String promedioCurso(String curso) throws NoExisteCurso, NoHayEstudiantes, NoHayNotas {

		Curso course = Curso.buscarCurso(curso);
		double prom = 0;
		for (Estudiante estudiante : course.getEstudiantes()) {
			prom += estudiante.getDefinitiva(curso);
		}
		prom = prom / (course.getEstudiantes()).size();
		DecimalFormat f = new DecimalFormat("#.00");
		return ("El promedio del curso es: " + f.format(prom) + "\n");
	}

	public void finalizeCurso() {

		while (alumnos.size() > 0) {
			Estudiante estudiante = alumnos.get(0);
			alumnos.remove(0);
			try {
				float nota = estudiante.getDefinitiva(nombre);
				if (nota >= 3) {
					estudiante.setEstado(nombre, 1);
					estudiante.addCertificado(new Certificado(tipo, estudiante, docente, nota));
				}
				estudiante.removeCurso(nombre);
			} catch (NoHayNotas excepcion) {
				estudiante.removeCurso(nombre);
			}

		}

		docente.removeCurso(nombre);
		Curso.removeCurso(nombre);
	}

	public String finalizarCurso(String nombre) {
		try {
			Curso curso = Curso.buscarCurso(nombre);
			curso.finalizeCurso();
			return "El curso ha sido finalizado.";
		} catch (NoExisteCurso excepcion) {
			return "No existe el curso.";
		}
	}
	
	// Añade un curso a la lista de cursos, recibe como parametro un curso y no
		// retorna nada
	static public void add(Curso c) {
		listaCursos.add(c);
	}
	
	
	/*
	 * Busca un curso en la lista de cursos por su nombre, recibe como parametro el
	 * nombre del curso a encontrar y retorna el curso en caso de que lo encuentre,
	 * si no lo encuentra retornara null
	 */
	static public Curso buscarCurso(String curso) throws NoExisteCurso {
		for (Curso x : listaCursos) {
			if (x.getNombreCurso().equals(curso)) {
				return x;
			}
		}
		throw new NoExisteCurso();
	}

	// Metodo que retorna un int que indica la cantidad de cupos que tiene un curso.
	// No recibe ningun parametro
	public int getCupos() {
		return cupos;
	}

	// Metodo que retorna un int que indica la cantidad de cupos disponibles que
	// tiene un curso. No recibe ningun parametro
	public int getCuposDisponibles() {
		return cupos - alumnos.size();
	}

	// Metodo que retorna la lista de los estudiantes matriculados en el curso. No
	// recibe ningun parametro
	public ArrayList<Estudiante> getEstudiantes() throws NoHayEstudiantes {
		if (!alumnos.isEmpty()) {
			return alumnos;
		} else {
			throw new NoHayEstudiantes();
		}

	}

	// Metodo que retorna el docente asignado al curso. No recibe ningun parametro
	public Docente getDocente() {
		return docente;
	}

	// Metodo que retorna un String que contiene el horario del curso. No recibe
	// ningun parametro
	public String getHorarioCurso() {
		return horario;
	}

	// Metodo que retorna un String que contiene el nombre del curso. No recibe
	// ningun parametro
	public String getNombreCurso() {
		return nombre;
	}

	// Metodo que retorna un String que contiene el tipo del curso. No recibe ningun
	// parametro
	public String getTipo() {
		return tipo;
	}

	/*
	 * Este metodo matricula estudiantes al curso, lo cual se traduce en añadir al
	 * estudiante a la lista de estudiantes del curso y añadir el curso en la lista
	 * de cursos del estudiante. Retorna un boolean, cuando es true significa que el
	 * estudiante fue matriculado satisfactoriamente, si retorna false es que no se
	 * pudo matricular al estudiante por falta de cupos. Recibe como parametro el
	 * estudiante al que se desea matricular en el curso.
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

	/*
	 * Metodo toString. Retorna un String que contiene el nombre del curso, el
	 * horario, el nombre del profesor que dicta el curso y los cupos disponibles.
	 * No recibe ningun parametro
	 */
	public String toString() {
		return "Nombre: " + nombre + "\nHorario: " + horario + "\nProfesor: " + docente.getNombre()
				+ "\nCupos disponibles: " + (cupos - alumnos.size());
	}

	/*
	 * Permite ver los estudiantes matriculados en el curso. Retorna un String con
	 * formato correcto que contiene el nombre y cedula de cada uno de los
	 * estudiantes que se encuentran matriculados. No recibe ningun parametro
	 */
	public String verEstudiantes() {
		String ver = "";
		for (Estudiante estudiante : alumnos) {
			ver += estudiante.toString() + "\n";
		}
		return ver;
	}

	/*
	 * Metodo que se ejecuta cuando java ejecuta el garbage collections. Indica que
	 * el curso ha sido borrado satisfactoriamente. No recibe ningun parametro ni
	 * retorna nada
	 */
	public void finalize() {
		System.out.println("\nEl curso " + nombre + " ha sido borrado del sistema.\n");
	}
	static public String crearCurso(String name, String tipo, long profesor, String horario) throws NoExisteCurso, NoExisteDocente, CursoExistente {
		Curso curso = null;
		try {
			curso = Curso.buscarCurso(name);
			throw new CursoExistente();
		} catch(NoExisteCurso excepcion) {
			Docente docente = null;
			docente = Docente.buscarDocente(profesor);
			Curso nuevoCurso = new Curso(name, tipo, horario, docente);
			return "Se ha creado el curso.";
		}
	}
	static public String verCursos() throws NoHayCursos {
		String ver = "";
		for (Curso x : listaCursos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (ver.equals("")) {
			throw new NoHayCursos();
		} else {
			return "Cursos:\n" + ver;
		}
	}
	static public void removeCurso(String nombre) {
		Iterator<Curso> I = listaCursos.iterator();
		while (I.hasNext()) {
			Curso x = I.next();
			if (x.getNombreCurso().equals(nombre)) {
				listaCursos.remove(x);
				break;
			}
		}
	}
	static public ArrayList<Curso> getCursos() {
		return listaCursos;
	}
	static public String FinalizeCurso(String nombreCurso) throws NoExisteCurso {
		Curso cursofinalizar = null;
		cursofinalizar = Curso.buscarCurso(nombreCurso);
		cursofinalizar.finalizeCurso();
		return "El curso ha sido finalizado";
	}
}