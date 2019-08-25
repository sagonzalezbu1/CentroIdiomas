package modelo.Usuarios;

import java.util.*;

import BaseDatos.Archivo;
import control.*;
import modelo.Centro.*;
import modelo.excepciones.*;

/*Esta clase permite crear objetos de tipo Estudiante, los cuales cumplir�n tareas como
 * hacer solicitudes, matricularse, etc*/
public class Estudiante extends Usuario implements Horario {
	// Dependiendo de los datos del estudiante, tendr� uno de tres estados posibles
	private String estado = "Inactivo";
	/*
	 * Atributos de datos tales como sus certificados, solicitudes, cursos inscritos
	 * y las notas de estos
	 */
	private ArrayList<Certificado> misCertificados = new ArrayList<Certificado>();
	private ArrayList<Solicitud> misSolicitudes = new ArrayList<Solicitud>();
	private ArrayList<Curso> misCursos = new ArrayList<Curso>();
	private HashMap<String, ArrayList<Float>> misNotas = new HashMap<>();

	// Constructor usado en la creaci�n de objetos de tipo Estudiante desde el
	// programa
	public Estudiante(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		// Se crea el men� de Estudiante con las funcionalidades por defecto
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add(Main.funcionalidades.get("Matricular"));
		getProcesos().add(Main.funcionalidades.get("VerCertificados"));
		getProcesos().add(Main.funcionalidades.get("VerSolicitudes"));
		getProcesos().add(Main.funcionalidades.get("VerHorario"));
		getProcesos().add(Main.funcionalidades.get("VerNotas"));
		getProcesos().add(Main.funcionalidades.get("SolicitarCupo"));
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("CerrarSesion"));
		Archivo.add(this);

	}

	/*
	 * Constructor usado en la creaci�n de objetos de tipo Estudiante desde la carga
	 * de los archivos de texto al programa
	 */
	public Estudiante(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		/*
		 * Aqu� tendr� el menu ya sea por defecto o editado, dependiendo de si el
		 * administrador lo haya editado
		 */
	}

	/*
	 * A�ade un certificado a lista de certificados del estudiante al momento de
	 * finalizar un curso y tener una nota mayor o igual a 3.0. Recibe como
	 * par�metro un objeto de tipo Certificado y no retorna nada
	 */
	public void addCertificado(Certificado certify) {
		misCertificados.add(certify);
	}

	/*
	 * A�ade un curso a lista de cursos del estudiante y al hashmap de sus notas
	 * junto a un ArrayList vac�o, que es donde ir�n las notas que le pondr� un
	 * docente. Recibe como par�metro un objeto de tipo Curso y no retorna nada
	 */
	public void addCurso(Curso course) {
		misCursos.add(course);
		misNotas.put(course.getNombreCurso(), new ArrayList<>());
	}

	/*
	 * A�ade una nota al estudiante en el curso especificado. Es de uso exclusivo
	 * para la carga de informaci�n de los archivos de texto al programa. Recibe
	 * como par�metros un objeto de tipo Curso y un float que ser� la nota. No
	 * retorna nada
	 */
	public void addNota(Curso course, float grade) {
		misNotas.get(course.getNombreCurso()).add(grade);
	}

	/*
	 * Usado por los docentes para calificar a los estudiantes en los cursos. Recibe
	 * como par�metros un String equivalente al nombre del curso y un float
	 * equivalente a la nota asignada. No retorna nada
	 */
	public void calificar(String name, float grade) {
		ArrayList<Float> itemsList = misNotas.get(name);
		itemsList.add(grade);
	}

	/*
	 * Getter de la lista de cursos del estudiante. Retorna el ArrayList de los
	 * cursos y no recibe par�metros
	 */
	public ArrayList<Curso> getCursos() throws noHayCursos {

		if (misCursos.isEmpty() == false) {
			return misCursos;
		} else {
			throw new noHayCursos();
		}

	}

	/*
	 * Retorna la nota definitiva/acumulada del estudiante en cierto curso. Recibe
	 * como par�metro un String equivalente al nombre del curso
	 */
	public float getDefinitiva(String name) {
		ArrayList<Float> prom = misNotas.get(name);
		float def = 0;

		for (Float nota : prom) {
			def += nota;
		}

		if (prom.size() == 0) {
			return 0;
		} else {
			def /= prom.size();
			return def;
		}
	}

	/*
	 * Getter del estado del estudiante. No recibe par�metros y devuelve un String
	 * equivalente al estado
	 */
	public String getEstado() {
		return estado;
	}

	// Getter de la lista de certificados del estudiante, retorna esta y no recibe
	// par�metros
	public ArrayList<Certificado> getCertificados() {
		return misCertificados;
	}

	// Getter de la lista de solicitudes hechas por el estudiante, retorna esta y no
	// recibe par�metros
	public ArrayList<Solicitud> getSolicitudes() {
		return misSolicitudes;
	}

	/*
	 * Getter de las notas del estudiante de todos los cursos en los que est�
	 * inscrito. Devuelve el HashMap de estas y no recibe par�metros
	 */
	public HashMap<String, ArrayList<Float>> getNotas() {
		return misNotas;
	}

	/*
	 * Retorna un String equivalente a las notas del estudiante en cierto curso, en
	 * un formato correcto. Recibe como par�metro un String del nombre del curso
	 */
	public String verNotas(String nombreM) {
		ArrayList<Float> prom = misNotas.get(nombreM);
		String list = " ";

		for (Float nota : prom) {
			list += nota + "  ";
		}

		list += "  Nota acumulada: " + this.getDefinitiva(nombreM);
		return list;
	}

	/*
	 * Retorna un String equivalente al horario del estudiante en un formato
	 * correcto. Implementa el m�todo de la interfaz Horario. No recibe par�metros
	 */
	public String miHorario() throws noHayHorario {
		String aux = "";
		for (Curso curso : misCursos) {
			aux += curso + "\n";
			aux += "\n";
		}

		if (aux.equals("")) {
			throw new noHayHorario();
		} else {
			return aux;
		}
	}

	/*
	 * M�todo usado por finalizeCurso al momento de cerrarse un curso, lo elimina de
	 * la lista del estudiante y del HashMap de notas. Recibe como par�metro un
	 * String del nombre del curso
	 */
	public void removeCurso(String nombreCurso) {
		Curso curso = null;

		for (Curso micurso : misCursos) {
			if (micurso.getNombreCurso().equals(nombreCurso)) {
				curso = micurso;
				break;
			}
		}

		misCursos.remove(curso);
		misNotas.remove(nombreCurso);
	}

	/*
	 * M�todo usado por ResponderSolicitudes al momento de responder una solicitud,
	 * elimin�ndola de la lista de solicitudes del estudiante. Recibe como par�metro
	 * un String con el tipo de la solicitud
	 */
	public void removeSolicitud(String tipo) {

		for (Solicitud solicitud : misSolicitudes) {
			if ((solicitud.getTipo()).equals(tipo)) {
				misSolicitudes.remove(solicitud);
				return;
			}
		}

	}

	// Sobrecarga del m�todo setEstado

	/*
	 * Setter del estado del estudiante para el m�todo matricular. Recibe como
	 * par�metro un entero enviado por el m�todo matricular de la clase Curso. No
	 * devuelve nada
	 */
	public void setEstado(int status) {
		if (status == 0) {
			estado = "Activo";
		}
	}

	/*
	 * Setter del estado del estudiante para el m�todo finalizeCurso. Recibe como
	 * par�metro un entero enviado por el m�todo finalizeCurso de la clase Curso. No
	 * devuelve nada
	 */
	public void setEstado(String mater, int status) {
		if (status == 1) {
			if (misCursos.size() > 1) {
				estado = "Activo";
			} else {
				float aux = this.getDefinitiva(mater);
				if (aux >= 3.0) {
					estado = "Egresado";
				} else {
					estado = "Inactivo";
				}
			}
		}
	}

	/*
	 * Crea un objeto de tipo Solicitud y lo agrega a la lista de solicitudes del
	 * estudiante. Recibe como par�metro un String del tipo del curso. No devuelve
	 * nada
	 */
	public void solicitar(String type) {
		Solicitud s = new Solicitud(type, this);
		misSolicitudes.add(s);
	}

	/*
	 * M�todo toString de Estudiante. Retorna un String de la informaci�n del
	 * estudiante de manera ordenada, es decir, su nombre y c�dula. No recibe
	 * par�metros
	 */
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

	/*
	 * Retorna un String equivalente a los certificados del estudiante, mostr�ndolos
	 * de manera correcta. No recibe par�metros
	 */
	public String verCertificados() throws noHayCertificados {
		String aux = "";
		for (Certificado certificado : misCertificados) {
			aux += certificado + "\n";
		}
		if (aux.equals("")) {
			throw new noHayCertificados();
		} else {
			return aux;
		}
	}

	/*
	 * Retorna un String equivalente a las solicitudes hechas por el estudiante,
	 * mostr�ndolas de manera correcta. No recibe par�metros
	 */
	public String verSolicitudes() throws noHaySolicitudes {
		String aux = "";

		for (Solicitud solicitud : misSolicitudes) {
			aux += solicitud + ",";
		}

		if (!aux.equals("")) {
			aux = aux.substring(0, aux.length() - 1);
			return aux;
		} else {
			throw new noHaySolicitudes();
		}

	}

	public String solicitarCupo(long CC, String tipo) {
		Estudiante estudiante = null;
		try {
			estudiante = Archivo.buscarEstudiante(CC);
			for (Curso curso : estudiante.getCursos()) {
				if (curso.getTipo().equals(tipo)) {
					return "Usted esta viendo un curso de este tipo, no puede solicitar.";
				}
			}

			for (Solicitud solicitud : estudiante.getSolicitudes()) {
				if (solicitud.getTipo().equals(tipo)) {
					return "Usted ya hizo una solicitud para este tipo, no puede solicitar.";
				}
			}

			for (Certificado certificado : estudiante.getCertificados()) {
				if (certificado.getNombre().equals(tipo)) {
					return "Usted ya aprobo una materia para este tipo, no puede solicitar.";
				}
			}

			if (Archivo.cursoDisponibilidad(tipo) == null) {
				estudiante.solicitar(tipo);
				return "Su solicitud ha sido exitosa.";
			} else {
				return "Hay cupos disponibles, no puede solicitar.\n";
			}
		} catch (noExisteEstudiante e) {
			return "No hay estudiante.";
		} catch (noHayCursos c) {
			for (Solicitud solicitud : estudiante.getSolicitudes()) {
				if (solicitud.getTipo().equals(tipo)) {
					return "Usted ya hizo una solicitud para este tipo, no puede solicitar.";
				}
			}

			for (Certificado certificado : estudiante.getCertificados()) {
				if (certificado.getNombre().equals(tipo)) {
					return "Usted ya aprobo una materia para este tipo, no puede solicitar.";
				}
			}

			if (Archivo.cursoDisponibilidad(tipo) == null) {
				estudiante.solicitar(tipo);
				return "Su solicitud ha sido exitosa.";
			} else {
				return "Hay cupos disponibles, no puede solicitar.\n";
			}
		}
	}

	public String matricularEstudiante(long CC, String nombrecurso) {
		Estudiante est = null;
		Curso curso = null;
		try {
			est = Archivo.buscarEstudiante(CC);
			curso = Archivo.buscarCurso(nombrecurso);

			for (Certificado certificado : est.getCertificados()) {
				if ((certificado.getNombre()).equals(curso.getTipo())) {
					return "Usted ya aprobo una curso de este tipo.";
				}
			}
			for (Solicitud solicitud : est.getSolicitudes()) {
				if ((solicitud.getTipo()).equals(curso.getTipo())) {
					return "Usted ya tiene una solicitud de este tipo.";
				}
			}
			for (Estudiante estudiante : curso.getEstudiantes()) {
				if (est.equals(estudiante)) {
					return "El estudiante ya se encuentra matriculado en este curso.";
				}
			}
			if (curso.getCuposDisponibles() > 0) {
				curso.matricular(est);
				return "El estudiante qued� matriculado.";
			} else {
				return "No hay cupos disponibles en este curso.";
			}
		} catch (noExisteEstudiante excepcion) {
			return "No existe estudiante.";
		} catch (noExisteCurso exception) {
			return "No existe el curso.";
		} catch (noHayEstudiantes excepcion) {
			curso.matricular(est);
			return "El estudiante qued� matriculado.";
		}

	}
}