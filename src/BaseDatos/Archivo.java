package BaseDatos;

import java.util.*;

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
	static private ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
	static private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
	static private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
	static private ArrayList<Curso> listaCursos = new ArrayList<Curso>();
	static private HashMap<String, ArrayList<Solicitud>> solicitudes = new HashMap<String, ArrayList<Solicitud>>();
	static private Administrador Admin = new Administrador("Jaime Guzman", 123, "admin@cdi.com", "123");
	static private ArrayList<Sugerencia> listaSugerencias = new ArrayList<Sugerencia>();

    //El metodo add esta sobrecargado, el a�adira a la lista correspondiente segun el tipo de dato que reciba
	
	//A�ade un administrativo a la lista de administrativos, recibe como parametro un administrativo y no retorna nada
	static public void add(Administrativo a) {
		listaAdministrativos.add(a);
	}
	//A�ade un curso a la lista de cursos, recibe como parametro un curso y no retorna nada
	static public void add(Curso c) {
		listaCursos.add(c);
	}
	//A�ade un docente a la lista de docentes, recibe como parametro un docente y no retorna nada
	static public void add(Docente d) {
		listaDocentes.add(d);
	}
	//A�ade un estudiante a la lista de estudiantes, recibe como parametro un estudiante y no retorna nada
	static public void add(Estudiante e) {
		listaEstudiantes.add(e);
	}
	//A�ade una sugernecia a la lista de sugerencias, recibe como parametro una sugerencia y no retorna nada
	static public void add(Sugerencia s) {
		listaSugerencias.add(s);
	}

	/*Busca un administrativo en la lista de administrativos por su cedula, recibe como parametro la cedula del adminitrativo a encontrar y retorna el administrativo
	  en caso de que lo encuentre, si no lo encuentra retornara null*/
	static public Administrativo buscarAdministrativo(long admin) {
		for (Administrativo x : listaAdministrativos) {
			if (x.getCedula() == admin) {
				return x;
			}
		}
		return null;
	}

	/*Busca un docente en la lista de docentes por su cedula, recibe como parametro la cedula del docente a encontrar y retorna el docente
	  en caso de que lo encuentre, si no lo encuentra retornara null*/
	static public Docente buscarDocente(long docen) {
		for (Docente x : listaDocentes) {
			if (x.getCedula() == docen) {
				return x;
			}
		}
		return null;
	}
	/*Busca un curso en la lista de cursos por su nombre, recibe como parametro el nombre del curso  a encontrar y retorna el curso
	  en caso de que lo encuentre, si no lo encuentra retornara null*/
	static public Curso buscarCurso(String curso) {
		for (Curso x : listaCursos) {
			if (x.getNombreCurso().equals(curso)) {
				return x;
			}
		}
		return null;
	}
	/*Busca un estudiante en la lista de estudiantes por su cedula, recibe como parametro la cedula del estudiante a encontrar y retorna el estudiante
	  en caso de que lo encuentre, si no lo encuentra retornara null*/
	static public Estudiante buscarEstudiante(long estud) throws noExisteEstudiante {
		for (Estudiante x : listaEstudiantes) {
			if (x.getCedula() == estud) {
				return x;
			}
		}
		throw new noExisteEstudiante();
	}
	/*Busca un usuario en las lista de estudiante,docente y administrativo por su cedula, recibe como parametro la cedula del usaurio a encontrar y retorna
      el usuario en caso de que lo encuentre, si no lo encuentra retornara null*/
	static public Usuario buscarUsuario(long id) {
		Usuario u = buscarAdministrativo(id);
		if (u == null) {
			u = buscarDocente(id);
			if (u == null) {
				u = buscarEstudiante(id);
			}
		}
		return u;
	}
    /*Busca si hay un curso con cupos disponibles, como parametro recibe el tipo del curso, y retornara el primer curso que encuentre con cupos disponibles
      del tipo que se le especifico, en caso de no haber cursos disponibles de ese tipo, retornara null */
	static public Curso cursoDisponibilidad(String tipo) {
		ArrayList<Curso> Cursos = getCursos();
		for (Curso c : Cursos) {
			if (c.getTipo().equals(tipo) && c.getCuposDisponibles() > 0) {
				return c;
			}
		}
		return null;
	}
	
    //Metodo que retorna al administrador del sistema, no recibe nada como parametro
	static public Administrador getAdministrador() {
		return Admin;
	}
	//Metodo que retorna la lista de administrativos, no recibe nada como parametro
	static public ArrayList<Administrativo> getAdministrativos() {
		return listaAdministrativos;
	}
	//Metodo que retorna la lista de cursos de archivo, no recibe nada como parametro
	static public ArrayList<Curso> getCursos() {
		return listaCursos;
	}
	//Metodo que retorna la lista de docentes, no recibe nada como parametro
	static public ArrayList<Docente> getDocentes() {
		return listaDocentes;
	}
	//Metodo que retorna la lista de estudiantes, no recibe nada como parametro
	static public ArrayList<Estudiante> getEstudiantes() {
		return listaEstudiantes;
	}
	//Metodo que retorna la lista de solicitudes, no recibe nada como parametro
	static public HashMap<String, ArrayList<Solicitud>> getSolicitudes() {
		return solicitudes;
	}
	//Metodo que retorna la lista de sugerencias, no recibe nada como parametro
	static public ArrayList<Sugerencia> getSugerencias() {
		return listaSugerencias;
	}

	/*Busca a un curso y luego lo remueve de la lista de cursos de archivo, recibe como parametro el nombre del curso a buscar y no retorna nada*/
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

	/*Borra una solicitud del hashmap de solicitudes de archivo, si ya no hay mas solicitudes de cierto tipo, remueve ese tipo del hashmap. Recibe como
	  parametros un String que corresponde al tipo de la solicitud (ingles,frances...etc) y una solicitud que es la que se va a remover. No retorna nada*/
	static public void removeSolicitud(String tipo, Solicitud s) {
		(solicitudes.get(tipo)).remove(s);
		if (solicitudes.get(tipo).isEmpty()) {
			solicitudes.remove(tipo);
		}
	}

	/*Permite ver a todos los administrativos registrados hasta el momento. No recibe ningun parametro. Retorna un String con formato correcto que contiene
	  al nombre y cedula de todos los administrativos*/
	static public String verAdministrativos() {
		String ver = "";
		for (Administrativo x : listaAdministrativos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		return "\nAdministrativos:\n" + ver;
	}
	/*Permite ver a todos los cursos no finalizados hasta el momento. No recibe ningun parametro. Retorna un String con formato correcto que contiene
	  al nombre, horario, docente, y cupos disponibles de todos los cursos que no hayan sido finalizados*/
	static public String verCursos() {
		String ver = "";
		for (Curso x : listaCursos) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (ver.equals("")) {
			return "\nNo hay cursos disponibles.\n";
		} else {
			return "\nCursos:\n" + ver;
		}
	}
	
	/*Permite ver a todos los sugerencias creadas hasta el momento. No recibe ningun parametro. Retorna un String con formato correcto que contiene
	  al nombre y cedula de quien hizo la sugerencia acompa�ado del mensaje que escribio en esta de todas las sugerencias*/
	static public String verSugerencias(){
		String ver = "";
		for(Sugerencia x : listaSugerencias){
			ver += x.toString() + "\n";
		}
		return "\nSugerencias:\n" + ver;
	}

	/*Permite ver a todos los docentes registrados hasta el momento. No recibe ningun parametro. Retorna un String con formato correcto que contiene
	  al nombre y cedula de todos los docentes*/
	static public String verDocentes() {
		String ver = "";
		for (Docente x : listaDocentes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		return "\nDocentes:\n" + ver;
	}
	/*Permite ver a todos los TIPOS  de solicitudes (no todas las solicitudes) no respondidas hasta el momento. No recibe ningun parametro. Retorna un String con formato correcto que contiene
	  todos los tipos de curso que tienen solicitudes*/
	static public String verSolicitudes() {
		String ver = "";
		for (String x : solicitudes.keySet()) {
			ver += x + "\n";
		}
		return "\nSolicitudes:\n" + ver;
	}
	/*Permite ver a todos los estudaintes registrados hasta el momento. No recibe ningun parametro. Retorna un String con formato correcto que contiene
	  al nombre y cedula de todos los estudiantes*/
	static public String verEstudiantes() {
		String ver = "";
		for (Estudiante x : listaEstudiantes) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		return "\nEstudiantes:\n" + ver;
	}

	/*Permite ver a todos los estudiantes que se encuentren matriculados en algun curso. Recibe como parametros un String con el nombre del curso. Retorna
	  un String con formato correcto que contiene los nombres y y las cedulas de todos los estudiantes matriculados en dicho curso */
	static public String verEstudiantesCurso(String curso) {
		String ver = "";
		for (Estudiante x : Archivo.buscarCurso(curso).getEstudiantes()) {
			ver += "\n";
			ver += x.toString() + "\n";
		}
		if (Archivo.buscarCurso(curso).getEstudiantes().isEmpty()) {
			return "\nEste curso no tiene estudiantes.\n";
		} else {
			return "\nEstudiantes de " + Archivo.buscarCurso(curso).getNombreCurso() + ":\n" + ver;
		}
	}
}