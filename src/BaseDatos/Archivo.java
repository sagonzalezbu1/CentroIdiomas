package BaseDatos;

import java.util.*;

import javax.swing.JOptionPane;

import defecto.Main;
import modelo.Centro.Curso;
import modelo.Centro.Solicitud;
import modelo.Centro.Sugerencia;
import modelo.Usuarios.*;
import modelo.excepciones.*;

/* La clase Archivo es donde guardamos todos los datos del Centro de Idiomas, lo que leen los metodos de la clase Data se guarda aqu� y queda guardado en
 * varias estructuras de datos. Es una clase abstracta ya que no hay objetos de tipo archivo, es uno solo y es global para todo nuestro centro de idiomas
 * 
 * En esta clase estan implementados metodos de busqueda de usuarios, solicitudes y sugerencias, los cuales se utilizaran en las demas clases que lo necesiten.
 */
abstract public class Archivo {
	

	// El metodo add esta sobrecargado, el a�adira a la lista correspondiente segun
	// el tipo de dato que reciba

	
	

	
	

	
	

	
	

	
	

	
	

	

	

	
	

	
	

	
	

	
	

	

	
	

	
	

	// Metodo que retorna la lista de administrativos, no recibe nada como parametro
	

	/
	

	

	

	

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
				// return ("Ya se encuentra registrado un usuario con esa c�dula.");
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
