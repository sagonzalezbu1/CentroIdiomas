package gestorAplicacion.Usuarios;

import java.util.*;
import uiMain.*;
import gestorAplicacion.Centro.*;

public class Administrativo extends Usuario {
	// private ArrayList <Solicitud> misSolicitudes;
	private static final String codigo = "1234";

	public static String getCodigo() {
		return codigo;
	}
	
	//Constructor para creacion de objeto
	public Administrativo(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		//Menu por defecto
		getMenu().anadirOpcion(Main.funcionalidades.get("CrearCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("FinalizeCurso"));
		getMenu().anadirOpcion(Main.funcionalidades.get("ResponderSolicitudes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerAdministrativos"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerDocentes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerTodosLosEstudiantes"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CerrarSesion"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerEstudiantesCurso"));
		Archivo.add(this);
		
	}
	
	//Constructor para carga de archivos
	public Administrativo(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(this);
		//Menu editado
	}

	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}
}