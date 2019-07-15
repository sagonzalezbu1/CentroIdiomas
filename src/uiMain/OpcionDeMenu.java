package uiMain;

import java.util.Scanner;
import gestorAplicacion.Usuarios.*;

//Clase de la que derivan todas las opciones
public abstract class OpcionDeMenu {
	private String nombre;
	
	//M�todo que s�lo ejecutar�n las opciones que pueda a�adir/eliminar el administrador
	public String getNombre() {
		return nombre;
	}
	
	//M�todos a implementar por todas las subclases
	public abstract void ejecutar();
	public abstract String toString();
}
