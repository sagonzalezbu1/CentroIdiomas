package modelo.Usuarios;


import BaseDatos.Archivo;
import control.*;

/*Esta clase permite crear objetos de tipo Administrativo, los cuales se encargar�n (valga la redundancia)
 * de las labores administrativas del centro de idiomas*/
public class Administrativo extends Usuario {
	//Para poder registrarse como Administrativo se necesita un c�digo especial
	private static final String codigo = "1234";
	//Retorna el c�digo especial para registrarse. No recibe par�metros
	public static String getCodigo() {
		return codigo;
	}
	
	//Constructor usado en la creaci�n de objetos de tipo Administrativo desde el programa
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
		getProcesos().add(Main.funcionalidades.get("VerCertificados"));		
		getProcesos().add(Main.funcionalidades.get("VerSolicitudes"));		
		getProcesos().add(Main.funcionalidades.get("VerNotas"));		
		getProcesos().add(Main.funcionalidades.get("HacerSugerencia"));
		getProcesos().add(Main.funcionalidades.get("VerSugerencias"));
		getProcesos().add(Main.funcionalidades.get("VerEstudiantesCurso"));
		getProcesos().add(Main.funcionalidades.get("PromedioCurso"));
		getProcesos().add(Main.funcionalidades.get("CerrarSesion"));
		Archivo.add(this);
		
	}
	
	/*Constructor usado en la creaci�n de objetos de tipo Administrativo desde la carga de 
	 * los archivos de texto al programa*/
	public Administrativo(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		/*Aqu� tendr� el menu ya sea por defecto o editado, 
		* dependiendo de si el administrador lo haya editado*/
	}
	//Retorna la informaci�n del administrativo, mostrando su nombre y c�dula
	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}
}