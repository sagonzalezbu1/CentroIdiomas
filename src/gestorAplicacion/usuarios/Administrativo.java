package gestorAplicacion.usuarios;

import java.util.*;
import uiMain.MenuDeConsola;
import gestorAplicacion.Centro.*;

public class Administrativo extends Usuario {
	// private ArrayList <Solicitud> misSolicitudes;
	private static final String codigo = "123456";

	public static String getCodigo() {
		return codigo;
	}
	
	//Constructor para creacion de objeto
	public Administrativo(String name, long cedula, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(cedula, clave);
		Archivo.add(this);
		//Menu por defecto
	}
	
	//Constructor para carga de archivos
	public Administrativo(long cedula, String name, String correo, String clave) {
		super(name, cedula, correo, clave);
		Archivo.add(cedula, clave);
		Archivo.add(this);
		//Menu editado
	}

	public String toString() {
		return ("Nombre: " + super.getNombre() + "\nCedula: " + super.getCedula());
	}
}