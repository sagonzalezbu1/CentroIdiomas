package uiMain;

import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;
import java.util.*;

import BaseDatos.Archivo;

/*Esta clase es usada por Administrador para ver todas las funcionalidades 
 * disponibles de cierto usuario.
 * 
 * En esta clase se ejecuta el método userSystemMenu localizado en la clase Administrador*/
public class UserMenu extends OpcionDeMenu {
	
	//Se muestran todas las funcionalidades del usuario especificado
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el ID de la persona a la cual quiere verle las funcionalidades: ");
		long IDuser = entry.nextInt();
		Usuario usuario = Archivo.buscarUsuario(IDuser);
		String texto = ((Administrador) Main.user).userSystemMenu(IDuser);
		
		if(usuario!=null) {
			System.out.println("\nLas opciones de menu de "+usuario.getNombre()+" cuya cedula es "+IDuser+" son: \n");
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