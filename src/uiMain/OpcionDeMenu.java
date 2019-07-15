package uiMain;

import java.util.Scanner;
import gestorAplicacion.Usuarios.*;

//Clase de la que derivan todas las opciones
public abstract class OpcionDeMenu {
	private String nombre;
	
	//Método que sólo ejecutarán las opciones que pueda añadir/eliminar el administrador
	public String getNombre() {
		return nombre;
	}
	
	//Métodos a implementar por todas las subclases
	public abstract void ejecutar();
	public abstract String toString();
}
