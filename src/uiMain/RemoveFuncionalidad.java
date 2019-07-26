package uiMain;

import java.util.*;

import BaseDatos.Archivo;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por el Administrador para eliminar funcionalidades a 
 * los menús de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el método eliminarOpcion localizado en la clase MenuDeConsola.*/
public class RemoveFuncionalidad extends OpcionDeMenu {
	
	/*Se hacen las respectivas verificaciones antes de eliminar la funcionalidad,
	 * como por ejemplo que el usuario sí tenga la funcionalidad,
	 * que el usuario exista y que la funcionalidad exista.
	 * No recibe parámetros y no retorna nada*/
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese la cedula del usuario al que desea eliminar una opcion: ");
		int cc = e.nextInt();
		Usuario y = null;
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == cc) {
				y = x;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == cc) {
				y = x;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == cc) {
				y = x;
			}
		}
		if (y != null) {
			MenuDeConsola menu = y.getMenu();
			int cont = 0;
			for (OpcionDeMenu x : menu.getList()) {
				if (!x.getNombre().equals("CerrarSesion")) {
					System.out.println("-" + x.getNombre());
				}

			}
			System.out.println("Ingrese el nombre de la opción que desea eliminar del menú: ");
			String i = e.next();
			for(OpcionDeMenu x : menu.getList()) {
				if(x.getNombre().equals(i) && !x.getNombre().equals("CerrarSesion")) {
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

	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Remover funcionalidad";
	}
}
