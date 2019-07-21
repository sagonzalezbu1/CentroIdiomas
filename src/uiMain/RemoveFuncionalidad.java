package uiMain;

import java.util.Scanner;
import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.Usuario;

public class RemoveFuncionalidad extends OpcionDeMenu {
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese la cedula del usuario al que desea eliminar una opcion: ");
		int cc = e.nextInt();
		Usuario y = null;
		//Se busca al usuario al que se le eliminará cierta funcionalidad
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
		//Se elimina la opción si el usuario existe
		if (y != null) {
			MenuDeConsola menu = y.getMenu();
			int cont = 0;
	        for (OpcionDeMenu x : menu.getList()) {
	            System.out.println(cont + ". " + x);
	            cont++;
	        }
	        System.out.println("Ingrese el número de la opción que desea eliminar del menú: ");
	        int i = e.nextInt();
	        if(i>=0 && i<menu.getList().size()) {
	        	menu.eliminarOpcion(i);
	        	System.out.println("\nLa opcion de menu fue eliminada con exito.\n");
	        }else {
	        	System.out.println("\nOpcion invalida.\n");
	        }
	        	
		}
		else {
			System.out.println("\nEl usuario no esta registrado.\n");
		}
	}

	public String toString() {
		return "Remover funcionalidad";
	}
}
