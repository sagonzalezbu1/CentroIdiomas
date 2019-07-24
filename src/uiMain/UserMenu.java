package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles de cierto usuario.
 * 
 * En esta clase se ejecuta el método userSystemMenu localizado en la clase Administrador*/
public class UserMenu extends OpcionDeMenu {
	
	//Se muestran todas las funcionalidades del usuario especificado
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el ID de la persona a la cual quiere verle las funcionalidades: ");
		long aux = entry.nextInt();
		Usuario u = Archivo.buscarUsuario(aux);
		String texto = ((Administrador) Main.user).userSystemMenu(aux);
		if(u!=null) {
			System.out.println("\nLas opciones de menu de "+u.getNombre()+" cuya cedula es "+aux+" son: \n");
			System.out.println(texto);
		}else {
			System.out.println(texto);
		}
	}

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Funcionalidades del Usuario";
	}
}