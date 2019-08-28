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

	static public String verCertificadosEstudiante(long CC) throws NoExisteEstudiante, NoHayCertificados {

		Estudiante estudiante = Archivo.buscarEstudiante(CC);
		String aux = estudiante.verCertificados();
		return aux;

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
