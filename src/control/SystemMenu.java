package control;

import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles del sistema.
 * 
 * En esta clase se ejecuta el método SystemMenu localizado en la clase Administrador*/
public class SystemMenu extends OpcionDeMenu {
	
	//Se muestran todas las funcionalidades del sistema
	public void ejecutar() {
		System.out.println("\nLas funcionalidades del sistema son: \n");
		System.out.println(((Administrador) Main.user).SystemMenu());
	}
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Funcionalidades del Sistema";
	}
}