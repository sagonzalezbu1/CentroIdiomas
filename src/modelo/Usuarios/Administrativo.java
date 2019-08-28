package modelo.Usuarios;

import java.util.ArrayList;

import BaseDatos.*;
import control.*;
import defecto.Main;

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
		Archivo.add(this);
		
	}
	
	/*Constructor usado en la creación de objetos de tipo Administrativo desde la carga de 
	 * los archivos de texto al programa*/
	public Administrativo(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		/*Aquí tendrá el menu ya sea por defecto o editado, 
		* dependiendo de si el administrador lo haya editado*/
	}
	//Retorna la información del administrativo, mostrando su nombre y cédula
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}
}