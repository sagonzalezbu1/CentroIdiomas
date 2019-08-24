package control;

import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles del sistema.
 * 
 * En esta clase se ejecuta el m�todo SystemMenu localizado en la clase Administrador*/
public class SystemMenu extends OpcionDeMenu {
	
	//Se muestran todas las funcionalidades del sistema
	public void ejecutar() {
		System.out.println("\nLas funcionalidades del sistema son: \n");
		System.out.println(((Administrador) Main.user).SystemMenu());
	}
	
	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Funcionalidades del Sistema";
	}
}