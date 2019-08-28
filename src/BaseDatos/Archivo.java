package BaseDatos;

import java.util.*;

import javax.swing.JOptionPane;

import defecto.Main;
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
	

	// El metodo add esta sobrecargado, el añadira a la lista correspondiente segun
	// el tipo de dato que reciba

	// Añade un administrativo a la lista de administrativos, recibe como parametro
	// un administrativo y no retorna nada
	

	static public void salir() {
		Data.guardarDatos();
		System.exit(0);
	}
	

	// Añade un curso a la lista de cursos, recibe como parametro un curso y no
	// retorna nada
	

	// Añade un docente a la lista de docentes, recibe como parametro un docente y
	// no retorna nada
	

	// Añade un estudiante a la lista de estudiantes, recibe como parametro un
	// estudiante y no retorna nada
	

	// Añade una sugernecia a la lista de sugerencias, recibe como parametro una
	// sugerencia y no retorna nada
	

	/*
	 * Busca un administrativo en la lista de administrativos por su cedula, recibe
	 * como parametro la cedula del adminitrativo a encontrar y retorna el
	 * administrativo en caso de que lo encuentre, si no lo encuentra retornara null
	 */

	

	/*
	 * Busca un docente en la lista de docentes por su cedula, recibe como parametro
	 * la cedula del docente a encontrar y retorna el docente en caso de que lo
	 * encuentre, si no lo encuentra retornara null
	 */
	

	/*
	 * Busca un curso en la lista de cursos por su nombre, recibe como parametro el
	 * nombre del curso a encontrar y retorna el curso en caso de que lo encuentre,
	 * si no lo encuentra retornara null
	 */
	

	/*
	 * Busca un estudiante en la lista de estudiantes por su cedula, recibe como
	 * parametro la cedula del estudiante a encontrar y retorna el estudiante en
	 * caso de que lo encuentre, si no lo encuentra retornara null
	 */
	

	/*
	 * Busca un usuario en las lista de estudiante,docente y administrativo por su
	 * cedula, recibe como parametro la cedula del usaurio a encontrar y retorna el
	 * usuario en caso de que lo encuentre, si no lo encuentra retornara null
	 */
	

	

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
	static public String verAdministrativos() throws NoHayAdministrativos {
		String ver = "";
		for (Administrativo x : listaAdministrativos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (ver.equals("")) {
			throw new NoHayAdministrativos();
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
	static public String verDocentes() throws NoHayDocentes {

		String ver = "";
		for (Docente x : listaDocentes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}

		if (!ver.equals("")) {
			return "\nDocentes:\n" + ver;
		} else {
			throw new NoHayDocentes();
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

	static public String registrarAministrativo(String nombre, String apellido, long cedula, String correo,
			String contrasena, String codigo) throws UsuarioRegistrado, CodigoIncorrecto {
		try {
			if (cedula == 123 || Archivo.buscarAdministrativo(cedula) instanceof Administrativo) {
				// return ("Ya se encuentra registrado un usuario con esa cédula.");
				throw new UsuarioRegistrado();
			} else {
				return "";
			}
		} catch (NoExisteAdministrativo exception) {
			if (codigo.equals(Administrativo.getCodigo())) {
				new Administrativo(nombre + " " + apellido, cedula, correo, contrasena);
				return "Se ha registrado exitosamente.";
			} else {
				throw new CodigoIncorrecto();
			}
		}
	}

	static public String registrarDocente(String nombre, String apellido, long cedula, String correo, String contrasena,
			String codigo) throws UsuarioRegistrado, CodigoIncorrecto {
		try {
			if (cedula == 123 || Archivo.buscarDocente(cedula) instanceof Docente) {
				throw new UsuarioRegistrado();
			} else {
				return "";
			}
		} catch (NoExisteDocente exception) {
			if (codigo.equals(Docente.getCodigo())) {
				new Docente(nombre + " " + apellido, cedula, correo, contrasena);
				return "Se ha registrado exitosamente.";
			} else {
				throw new CodigoIncorrecto();
			}
		}
	}

	static public String registrarEstudiante(String nombre, String apellido, long cedula, String correo,
			String contrasena) throws UsuarioRegistrado {
		try {
			if (cedula == 123 || Archivo.buscarEstudiante(cedula) instanceof Estudiante) {
				throw new UsuarioRegistrado();
			} else {
				return "";
			}
		} catch (NoExisteEstudiante exception) {
			new Estudiante(nombre + " " + apellido, cedula, correo, contrasena);
			return "Se ha registrado exitosamente";
		}
	}

	static public String FinalizeCurso(String nombreCurso) throws NoExisteCurso {
		Curso cursofinalizar = null;
		cursofinalizar = Archivo.buscarCurso(nombreCurso);
		cursofinalizar.finalizeCurso();
		return "El curso ha sido finalizado";
	}

	static public boolean DocenteCorrecto(String curso, long cedula) throws NoExisteCurso, DocenteIncorrecto {
		if (Archivo.buscarCurso(curso).getDocente().getCedula() == cedula) {
			return true;
		} else {
			throw new DocenteIncorrecto();
		}
	}

	static public void PreCalificar(String curso, long cedula) throws NoExisteCurso, DocenteIncorrecto, NoHayEstudiantes {
		Curso cursocalificar = null;
		cursocalificar = Archivo.buscarCurso(curso);
		DocenteCorrecto(curso, cedula);
		if (cursocalificar.getEstudiantes().size() == 0) {
			throw new NoHayEstudiantes();
		}
	}

	/*static public void Calificar(String curso, long cedula) throws NoExisteCurso,NoHayEstudiantes {
			String respuesta = JOptionPane.showInputDialog(null, "Ingrese La nota del estudiante", "Calificacion",JOptionPane.INFORMATION_MESSAGE);
			x.calificar(curso, Float.parseFloat(respuesta));

		}
	}*/

	/*
	 * public void ejecutar() { Scanner entry = new Scanner(System.in);
	 * System.out.println("Introduzca el nombre del grupo al que desea calificar: "
	 * ); String cursocalificar = entry.next(); boolean existenciacurso = false;
	 * 
	 * for (Curso curso : Archivo.getCursos()) {
	 * 
	 * if (curso.getNombreCurso().equals(cursocalificar)) { existenciacurso = true;
	 * System.out.println("Introduzca la cedula del docente que da el curso: ");
	 * long ccdocente = entry.nextLong(); if (ccdocente ==
	 * curso.getDocente().getCedula()) {
	 * 
	 * if (curso.getEstudiantes().size() == 0) {
	 * System.out.println("\nEste curso no tiene estudiantes inscritos.\n"); } else
	 * {
	 * 
	 * for (Estudiante estudiante : curso.getEstudiantes()) { long id =
	 * estudiante.getCedula();
	 * System.out.println("Ingrese la nota del estudiante con ID " + id +
	 * " (si la nota es un float escribirla con coma): "); float calificacion =
	 * entry.nextFloat();
	 * 
	 * while(calificacion<0 || calificacion>5) {
	 * System.out.println("Ingrese una nota valida: "); calificacion =
	 * entry.nextFloat(); }
	 * 
	 * System.out.println(""); estudiante.calificar(cursocalificar, calificacion); }
	 * 
	 * System.out.println("Ya no quedan estudiantes por calificar.\n");
	 * 
	 * }
	 * 
	 * } else { System.out.println("\nLa cedula del docente no es correcta.\n"); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * if (existenciacurso == false) { System.out.println("\nEl curso '" +
	 * cursocalificar + "' no existe.\n"); } }
	 */

}
