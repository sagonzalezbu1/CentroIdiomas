package modelo.Usuarios;

import java.util.ArrayList;

import BaseDatos.*;
import control.*;
import defecto.Main;
import modelo.excepciones.modelo.CodigoIncorrecto;
import modelo.excepciones.modelo.NoExisteAdministrativo;
import modelo.excepciones.modelo.NoHayAdministrativos;
import modelo.excepciones.modelo.UsuarioRegistrado;


/*Esta clase permite crear objetos de tipo Administrativo, los cuales se encargarán (valga la redundancia)
 * de las labores administrativas del centro de idiomas*/
public class Administrativo extends Usuario {
	
	static private ArrayList<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
	
	//Para poder registrarse como Administrativo se necesita un código especial
	private static final String codigo = "1234";
	//Retorna el código especial para registrarse. No recibe parámetros
	public static String getCodigo() {
		return codigo;
	}
	
	//Constructor usado en la creación de objetos de tipo Administrativo desde el programa
	public Administrativo(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		//Se crea el menu de Administrativo con las funcionalidades por defecto
		getProcesos().add(Main.funcionalidades.get("CrearCurso"));
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add(Main.funcionalidades.get("FinalizeCurso"));
		getProcesos().add(Main.funcionalidades.get("ResponderSolicitudes"));
		getProcesos().add(Main.funcionalidades.get("VerAdministrativos"));
		getProcesos().add(Main.funcionalidades.get("VerDocentes"));
		getProcesos().add(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getProcesos().add(Main.funcionalidades.get("VerCertificadosEstudiante"));		
		getProcesos().add(Main.funcionalidades.get("VerSolicitudesEstudiante"));		
		getProcesos().add(Main.funcionalidades.get("VerNotasEstudiante"));		
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("VerSugerencias"));
		getProcesos().add(Main.funcionalidades.get("VerEstudiantesCurso"));
		getProcesos().add(Main.funcionalidades.get("PromedioCurso"));
		getProcesos().add(Main.funcionalidades.get("RegistrarDocente"));
		getProcesos().add(Main.funcionalidades.get("RegistrarEstudiante"));
		getProcesos().add(Main.funcionalidades.get("RegistrarAdministrativo"));
		Administrativo.add(this);
		
	}
	
	/*Constructor usado en la creación de objetos de tipo Administrativo desde la carga de 
	 * los archivos de texto al programa*/
	public Administrativo(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Administrativo.add(this);
		/*Aquí tendrá el menu ya sea por defecto o editado, 
		* dependiendo de si el administrador lo haya editado*/
	}
	//Retorna la información del administrativo, mostrando su nombre y cédula
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}

	// Añade un administrativo a la lista de administrativos, recibe como parametro
		// un administrativo y no retorna nada
	static public void add(Administrativo a) {
		listaAdministrativos.add(a);
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
	
	// Metodo que retorna la lista de administrativos, no recibe nada como parametro
	static public ArrayList<Administrativo> getAdministrativos() {
		return listaAdministrativos;
	}
	static public String registrarAministrativo(String nombre, String apellido, long cedula, String correo,
			String contrasena, String codigo) throws UsuarioRegistrado, CodigoIncorrecto {
		try {
			if (cedula == 123 || Administrativo.buscarAdministrativo(cedula) instanceof Administrativo) {
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
}