package BaseDatos;

import java.util.*;

import control.Main;
import modelo.Centro.Curso;
import modelo.Centro.Solicitud;
import modelo.Centro.Sugerencia;
import modelo.Usuarios.*;
import modelo.excepciones.*;

/* La clase Archivo es donde guardamos todos los datos del Centro de Idiomas, lo que leen los metodos de la clase Data se guarda aquí y queda guardado en
 * varias estructuras de datos. Es una clase abstracta ya que no hay objetos de tipo archivo, es uno solo y es global para todo nuestro centro de idiomas
 * 
 * En esta clase estan implementados metodos de busqueda de usuarios, solicitudes y sugerencias, los cuales se utilizaran en las demas clases que lo necesiten.
 */
abstract public class Archivo {
	static private ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
	static private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
	static private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
	static private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	static private HashMap<String, ArrayList<Solicitud>> solicitudes = new HashMap<String, ArrayList<Solicitud>>();
	static private Administrador Admin = new Administrador();
	static private ArrayList<Sugerencia> listaSugerencias = new ArrayList<Sugerencia>();

	// El metodo add esta sobrecargado, el añadira a la lista correspondiente segun
	// el tipo de dato que reciba

	// Añade un administrativo a la lista de administrativos, recibe como parametro
	// un administrativo y no retorna nada
	static public String verSolicitudesEstudiante(long CC) throws NoHaySolicitudes, NoExisteEstudiante {
		return (Archivo.buscarEstudiante(CC)).verSolicitudes();

	}

	static public void salir() {
		Data.guardarDatos();
		System.exit(0);
	}

	static public String verNotasEstudiante(long CC) throws NoExisteEstudiante, EstudianteSinCursos {
		Estudiante estudiante = Archivo.buscarEstudiante(CC);
		String notas = "";
		for (Curso curso : estudiante.getCursos()) {
			notas += curso.getNombreCurso() + ": " + estudiante.verNotas(curso.getNombreCurso()) + "\n";
		}
		return notas;

	}

	static public String verHorarioEstudiante(long CC) throws NoExisteEstudiante, NoHayHorario {
		return (Archivo.buscarEstudiante(CC)).miHorario();

	}

	static public String verHorarioDocente(long CC) throws NoExisteDocente, NoHayHorario {
		return (Archivo.buscarDocente(CC)).miHorario();

	}

	static public String verCertificadosEstudiante(long CC) {
		try {
			Estudiante estudiante = Archivo.buscarEstudiante(CC);
			String aux = estudiante.verCertificados();
			return aux;
		} catch (NoExisteEstudiante excepcion) {
			return "No existe estudiante";
		} catch (NoHayCertificados excepcion) {
			return "No tiene certificados.";
		}

	}

	static public void add(Administrativo a) {
		listaAdministrativos.add(a);
	}

	// Añade un curso a la lista de cursos, recibe como parametro un curso y no
	// retorna nada
	static public void add(Curso c) {
		listaCursos.add(c);
	}

	// Añade un docente a la lista de docentes, recibe como parametro un docente y
	// no retorna nada
	static public void add(Docente d) {
		listaDocentes.add(d);
	}

	// Añade un estudiante a la lista de estudiantes, recibe como parametro un
	// estudiante y no retorna nada
	static public void add(Estudiante e) {
		listaEstudiantes.add(e);
	}

	// Añade una sugernecia a la lista de sugerencias, recibe como parametro una
	// sugerencia y no retorna nada
	static public void add(Sugerencia s) {
		listaSugerencias.add(s);
	}

	/*
	 * Busca un administrativo en la lista de administrativos por su cedula, recibe
	 * como parametro la cedula del adminitrativo a encontrar y retorna el
	 * administrativo en caso de que lo encuentre, si no lo encuentra retornara null
	 */

	static public Administrativo buscarAdministrativo(long admin) throws NoExisteAdministrativo {
		for (Administrativo x : listaAdministrativos) {
			if (x.getCedula() == admin) {
				return x;
			}
		}

		throw new NoExisteAdministrativo();

	}

	/*
	 * Busca un docente en la lista de docentes por su cedula, recibe como parametro
	 * la cedula del docente a encontrar y retorna el docente en caso de que lo
	 * encuentre, si no lo encuentra retornara null
	 */
	static public Docente buscarDocente(long docen) throws NoExisteDocente {
		for (Docente x : listaDocentes) {
			if (x.getCedula() == docen) {
				return x;
			}
		}
		throw new NoExisteDocente();
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

	/*
	 * Busca un estudiante en la lista de estudiantes por su cedula, recibe como
	 * parametro la cedula del estudiante a encontrar y retorna el estudiante en
	 * caso de que lo encuentre, si no lo encuentra retornara null
	 */
	static public Estudiante buscarEstudiante(long estud) throws NoExisteEstudiante {
		for (Estudiante x : listaEstudiantes) {
			if (x.getCedula() == estud) {
				return x;
			}
		}
		throw new NoExisteEstudiante();
	}

	/*
	 * Busca un usuario en las lista de estudiante,docente y administrativo por su
	 * cedula, recibe como parametro la cedula del usaurio a encontrar y retorna el
	 * usuario en caso de que lo encuentre, si no lo encuentra retornara null
	 */
	static public Usuario buscarUsuario(long id) throws NoExisteUsuario {
		try {
			if (id == 123) {
				return new Administrador();
			}
			return buscarAdministrativo(id);
		} catch (NoExisteAdministrativo excepcion1) {
			try {
				return buscarDocente(id);
			} catch (NoExisteDocente excepcion2) {
				try {
					return buscarEstudiante(id);
				} catch (NoExisteEstudiante excepcion3) {
					throw new NoExisteUsuario();
				}
			}

		}
	}

	static public Usuario buscarUser(long id) throws NoExisteUsuario {
		try {
			return buscarAdministrativo(id);
		} catch (NoExisteAdministrativo excepcion1) {
			try {
				return buscarDocente(id);
			} catch (NoExisteDocente excepcion2) {
				try {
					return buscarEstudiante(id);
				} catch (NoExisteEstudiante excepcion3) {
					throw new NoExisteUsuario();
				}
			}
		}
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

	// Metodo que retorna al administrador del sistema, no recibe nada como
	// parametro
	static public Administrador getAdministrador() {
		return Admin;
	}

	// Metodo que retorna la lista de administrativos, no recibe nada como parametro
	static public ArrayList<Administrativo> getAdministrativos() {
		return listaAdministrativos;
	}

	// Metodo que retorna la lista de cursos de archivo, no recibe nada como
	// parametro
	static public ArrayList<Curso> getCursos() {
		return listaCursos;
	}

	// Metodo que retorna la lista de docentes, no recibe nada como parametro
	static public ArrayList<Docente> getDocentes() {
		return listaDocentes;
	}

	// Metodo que retorna la lista de estudiantes, no recibe nada como parametro
	static public ArrayList<Estudiante> getEstudiantes() {
		return listaEstudiantes;
	}

	// Metodo que retorna la lista de solicitudes, no recibe nada como parametro
	static public HashMap<String, ArrayList<Solicitud>> getSolicitudes() {
		return solicitudes;
	}

	// Metodo que retorna la lista de sugerencias, no recibe nada como parametro
	static public ArrayList<Sugerencia> getSugerencias() {
		return listaSugerencias;
	}

	/*
	 * Busca a un curso y luego lo remueve de la lista de cursos de archivo, recibe
	 * como parametro el nombre del curso a buscar y no retorna nada
	 */
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

	/*
	 * Borra una solicitud del hashmap de solicitudes de archivo, si ya no hay mas
	 * solicitudes de cierto tipo, remueve ese tipo del hashmap. Recibe como
	 * parametros un String que corresponde al tipo de la solicitud
	 * (ingles,frances...etc) y una solicitud que es la que se va a remover. No
	 * retorna nada
	 */
	static public void removeSolicitud(String tipo, Solicitud s) {
		(solicitudes.get(tipo)).remove(s);
		if (solicitudes.get(tipo).isEmpty()) {
			solicitudes.remove(tipo);
		}
	}

	/*
	 * Permite ver a todos los administrativos registrados hasta el momento. No
	 * recibe ningun parametro. Retorna un String con formato correcto que contiene
	 * al nombre y cedula de todos los administrativos
	 */
	static public String verAdministrativos() {
		String ver = "";
		for (Administrativo x : listaAdministrativos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (ver.equals("")) {
			return "No hay administrativos.";
		} else {
			return "Administrativos:\n" + ver;
		}
	}

	/*
	 * Permite ver a todos los cursos no finalizados hasta el momento. No recibe
	 * ningun parametro. Retorna un String con formato correcto que contiene al
	 * nombre, horario, docente, y cupos disponibles de todos los cursos que no
	 * hayan sido finalizados
	 */
	static public String verCursos() {
		String ver = "";
		for (Curso x : listaCursos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (ver.equals("")) {
			return "No hay cursos disponibles.";
		} else {
			return "Cursos:\n" + ver;
		}
	}

	/*
	 * Permite ver a todos los sugerencias creadas hasta el momento. No recibe
	 * ningun parametro. Retorna un String con formato correcto que contiene al
	 * nombre y cedula de quien hizo la sugerencia acompañado del mensaje que
	 * escribio en esta de todas las sugerencias
	 */
	static public String verSugerencias() throws NoHaySugerencias {

		String ver = "";
		for (Sugerencia x : listaSugerencias) {
			ver += "\n";
			ver += x.toString() + "\n";
		}

		if (!ver.equals("")) {
			return "Sugerencias:\n" + ver;
		} else {
			throw new NoHaySugerencias();
		}

	}

	/*
	 * Permite ver a todos los docentes registrados hasta el momento. No recibe
	 * ningun parametro. Retorna un String con formato correcto que contiene al
	 * nombre y cedula de todos los docentes
	 */
	static public String verDocentes() {

		String ver = "";
		for (Docente x : listaDocentes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}

		if (!ver.equals("")) {
			return "\nDocentes:\n" + ver;
		} else {
			return "No hay docentes.";
		}

	}

	/*
	 * Permite ver a todos los TIPOS de solicitudes (no todas las solicitudes) no
	 * respondidas hasta el momento. No recibe ningun parametro. Retorna un String
	 * con formato correcto que contiene todos los tipos de curso que tienen
	 * solicitudes
	 */
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

	/*
	 * Permite ver a todos los estudaintes registrados hasta el momento. No recibe
	 * ningun parametro. Retorna un String con formato correcto que contiene al
	 * nombre y cedula de todos los estudiantes
	 */
	static public String verEstudiantes() throws NoHayEstudiantes {
		String ver = "";
		for (Estudiante x : listaEstudiantes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}

		if (!ver.equals("")) {
			return "\nEstudiantes:\n" + ver;
		} else {
			throw new NoHayEstudiantes();
		}

	}

	/*
	 * Permite ver a todos los estudiantes que se encuentren matriculados en algun
	 * curso. Recibe como parametros un String con el nombre del curso. Retorna un
	 * String con formato correcto que contiene los nombres y y las cedulas de todos
	 * los estudiantes matriculados en dicho curso
	 */
	static public String verEstudiantesCurso(String curso) throws NoExisteCurso, NoHayEstudiantes {

		String ver = "";
		for (Estudiante x : Archivo.buscarCurso(curso).getEstudiantes()) {
			ver += x.toString() + "\n";
		}
		return ver;

	}

	static public void verificarUsuario(long cc, String pass) throws NoExisteUsuario, LoginInvalido {
		if (Archivo.buscarUser(cc).getContrasena().equals(pass)) {
			return;
		}
		throw new LoginInvalido();
	}

	static public String ingresarUsuario(long cc, String pass) {
		try {
			Usuario usuario = Archivo.buscarUser(cc);
			Archivo.verificarUsuario(cc, pass);
			Main.user = usuario;
			return "Se ha iniciado sesion.";
		} catch (NoExisteUsuario exception1) {
			return "Usuario Incorrecto";

		} catch (LoginInvalido exception2) {
			return "Clave Incorrecta.";
		}
	}

	static public Administrador buscarAdministrador(long cc) throws NoExisteAdministrador {
		if (Archivo.getAdministrador().getCedula() == cc) {
			return Archivo.getAdministrador();
		}
		throw new NoExisteAdministrador();
	}

	static public void verificarAdministrador(long cc, String pass) throws NoExisteAdministrador, LoginInvalido {
		if (Archivo.buscarAdministrador(cc).getContrasena().equals(pass)) {
			return;
		}
		throw new LoginInvalido();
	}

	static public String ingresarAdmin(long cc, String pass) {
		try {
			Usuario usuario = Archivo.buscarAdministrador(cc);
			Archivo.verificarAdministrador(cc, pass);
			Main.user = usuario;
			return "Se ha iniciado sesion.";
		} catch (NoExisteAdministrador exception1) {
			return "Usuario Incorrecto.";
		} catch (LoginInvalido exception2) {
			return "Clave Incorrecta.";
		}
	}
}