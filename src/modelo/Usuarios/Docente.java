package modelo.Usuarios;

import java.util.*;


import control.*;
import defecto.Main;
import modelo.Centro.*;
import modelo.excepciones.*;
import modelo.excepciones.modelo.CodigoIncorrecto;
import modelo.excepciones.modelo.DocenteIncorrecto;
import modelo.excepciones.modelo.NoExisteCurso;
import modelo.excepciones.modelo.NoExisteDocente;
import modelo.excepciones.modelo.NoHayDocentes;
import modelo.excepciones.modelo.NoHayEstudiantes;
import modelo.excepciones.modelo.NoHayHorario;
import modelo.excepciones.modelo.UsuarioRegistrado;

/*Esta clase permite crear objetos de tipo Docente, los cuales cumplir�n tareas como
 * calificar a los estudiantes de los cursos que est�n dictando*/
public class Docente extends Usuario implements Horario {
	
	static private ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
	
	//Lista de los cursos que dicta el docente
	private ArrayList<Curso> misCursos = new ArrayList<>();
	//Para poder registrarse como Docente se necesita un c�digo especial
	private static final String codigo = "0000";
	//Retorna el c�digo especial para registrarse. No recibe par�metros
	public static String getCodigo() {
		return codigo;
	}

	//Constructor usado en la creaci�n de objetos de tipo Docente desde el programa
	public Docente(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		//Se crea el menu de Docente con las funcionalidades por defecto
		getProcesos().add(Main.funcionalidades.get("Calificar"));
		getProcesos().add(Main.funcionalidades.get("VerHorario"));
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add(Main.funcionalidades.get("VerDocentes"));
		getProcesos().add(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getProcesos().add(Main.funcionalidades.get("VerEstudiantesCurso"));
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("VerSugerencias"));
		getProcesos().add(Main.funcionalidades.get("PromedioCurso"));
		Docente.add(this);

	}

	/*Constructor usado en la creaci�n de objetos de tipo Docente desde la carga de 
	 * los archivos de texto al programa*/
	public Docente(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Docente.add(this);
		/*Aqu� tendr� el menu ya sea por defecto o editado, 
		* dependiendo de si el administrador lo haya editado*/
	}

	/*A�ade un curso a la lista de cursos del docente, recibe como 
	* par�metro un Curso y no retorna nada*/
	public void addCurso(Curso course) {
		misCursos.add(course);
	}

	/*Retorna el horario de los cursos que dicta el docente, 
	 * busc�ndolos en la lista de cada uno. No recibe par�metros*/
	public String miHorario() throws NoHayHorario{
		String aux = "";
		for (Curso curso : misCursos) {
			aux += "\nNombre: " + curso.getNombreCurso() + "\n" + "Horario: " + curso.getHorarioCurso();
			aux +="\n";
		}
		
		if (aux.equals("")) {
			throw new NoHayHorario();
		} else {
			return aux;
		}
	}

	/*Borra un curso de la lista de cursos del docente, busc�ndolo en la lista de cada uno.
	 * No recibe par�metros y no retorna nada*/
	public void removeCurso(String nombreCurso) {
		Curso y = null;
		for (Curso curso : misCursos) {
			if (curso.getNombreCurso().equals(nombreCurso)) {
				y = curso;
			}
		}
		misCursos.remove(y);
	}
	
	// A�ade un docente a la lista de docentes, recibe como parametro un docente y
		// no retorna nada
	static public void add(Docente d) {
		listaDocentes.add(d);
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
	
	static public String verHorarioDocente(long CC) throws NoExisteDocente, NoHayHorario {
		return (Docente.buscarDocente(CC)).miHorario();

	}
	
	/*Retorna la informaci�n del docente de manera correcta, mostrando su nombre y c�dula.
	 * No recibe par�metros*/
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}
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
	static public ArrayList<Docente> getDocentes() {
		return listaDocentes;
	}
	
	static public boolean DocenteCorrecto(String curso, long cedula) throws NoExisteCurso, DocenteIncorrecto {
		if (Curso.buscarCurso(curso).getDocente().getCedula() == cedula) {
			return true;
		} else {
			throw new DocenteIncorrecto();
		}
	}
	
	static public void PreCalificar(String curso, long cedula) throws NoExisteCurso, DocenteIncorrecto, NoHayEstudiantes {
		Curso cursocalificar = null;
		cursocalificar = Curso.buscarCurso(curso);
		DocenteCorrecto(curso, cedula);
		if (cursocalificar.getEstudiantes().size() == 0) {
			throw new NoHayEstudiantes();
		}
	}
	static public String registrarDocente(String nombre, String apellido, long cedula, String correo, String contrasena,
			String codigo) throws UsuarioRegistrado, CodigoIncorrecto {
		try {
			if (cedula == 123 || Docente.buscarDocente(cedula) instanceof Docente) {
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
}