package modelo.Usuarios;


import BaseDatos.Archivo;
import control.*;

/*Esta clase permite crear objetos de tipo Administrativo, los cuales se encargarán (valga la redundancia)
 * de las labores administrativas del centro de idiomas*/
public class Administrativo extends Usuario {
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
		getMenu().anadirOpcion(Main.funcionalidades.get("CrearCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("FinalizeCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("ResponderSolicitudes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerAdministrativos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerDocentes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCertificados"));		
		getMenu().anadirOpcion(Main.funcionalidades.get("VerSolicitudes"));		
		getMenu().anadirOpcion(Main.funcionalidades.get("VerNotas"));		
		getMenu().anadirOpcion(Main.funcionalidades.get("HacerSugerencia"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerSugerencias"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerEstudiantesCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("PromedioCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));
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