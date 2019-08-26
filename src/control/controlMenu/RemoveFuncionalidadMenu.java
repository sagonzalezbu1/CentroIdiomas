package control.controlMenu;

import java.util.*;

import BaseDatos.Archivo;
import control.OpcionDeMenu;
import modelo.Centro.*;
import modelo.Usuarios.*;

/*Esta clase es usada por el Administrador para eliminar funcionalidades a 
 * los men�s de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el m�todo eliminarOpcion localizado en la clase MenuDeConsola.*/
public class RemoveFuncionalidadMenu extends OpcionDeMenu {
	
	/*Se hacen las respectivas verificaciones antes de eliminar la funcionalidad,
	 * como por ejemplo que el usuario s� tenga la funcionalidad,
	 * que el usuario exista y que la funcionalidad exista.
	 * No recibe par�metros y no retorna nada*/
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese la cedula del usuario al que desea eliminar una opcion: ");
		int cc = entry.nextInt();
		Usuario user = null;
		
		for (Usuario usuario : Archivo.getEstudiantes()) {
			if (usuario.getCedula() == cc) {
				user = usuario;
			}
		}
		
		for (Usuario usuario : Archivo.getDocentes()) {
			if (usuario.getCedula() == cc) {
				user = usuario;
			}
		}
		
		for (Usuario usuario : Archivo.getAdministrativos()) {
			if (usuario.getCedula() == cc) {
				user = usuario;
			}
		}
		
		if (user != null) {
			MenuDeConsola menu = user.getMenu();
			int cont = 0;
			
			for (OpcionDeMenu opcion : menu.getList()) {
				if (!opcion.getNombre().equals("CerrarSesion")) {
					System.out.println("-" + opcion.getNombre());
				}
			}
			
			System.out.println("Ingrese el nombre de la opci�n que desea eliminar del men�: ");
			String opcioneliminar = entry.next();
			
			for(OpcionDeMenu opcion : menu.getList()) {
				if(opcion.getNombre().equals(opcioneliminar) && !opcion.getNombre().equals("CerrarSesion")) {
					menu.eliminarOpcion(cont);
					System.out.println("\nLa opcion de menu fue eliminada con exito.\n");
					return;
				}
				cont++;
			}
			
			System.out.println("\nOpcion invalida.\n");

		} else {
			System.out.println("\nEl usuario no esta registrado.\n");
		}
	}

	/*M�todo toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrar� por pantalla en el men�*/
	public String toString() {
		return "Remover funcionalidad";
	}
}
