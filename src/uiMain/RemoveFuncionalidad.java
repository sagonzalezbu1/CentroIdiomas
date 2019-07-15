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
			menu.eliminarOpcion();
		}
		else {
			System.out.println("El usuario no esta registrado");
		}
	}

	public String toString() {
		return "Remover funcionalidad";
	}
}
