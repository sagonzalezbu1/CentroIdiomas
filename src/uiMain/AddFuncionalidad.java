package uiMain;

import java.util.*;
import gestorAplicacion.Centro.*;
import gestorAplicacion.Usuarios.*;

/*Esta clase es usada por el Administrador para agregar funcionalidades a 
 * los menús de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el método anadirOpcion localizado en la clase MenuDeConsola.*/
public class AddFuncionalidad extends OpcionDeMenu {
	/*Se hacen las respectivas verificaciones antes de agregar la funcionalidad,
	 * como por ejemplo que la funcionalidad no esté ya en el menú del usuario,
	 * que el usuario no exista o que la funcionalidad no exista.
	 * No recibe parámetros y no retorna nada*/
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese la cedula del usuario al que desea agregar una funcionalidad: ");
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
		if (y != null ) {
			System.out.println(Archivo.getAdministrador().SystemMenu());
			System.out.println("Ingrese la funcionalidad que quiere agregar: ");
			String option = e.next();
			ArrayList<OpcionDeMenu> menu= y.getMenu().getList();
			for(OpcionDeMenu op: menu) {
				if(op.getNombre().equals(option)) {
					System.out.println("\nLa opcion de menu ya esta disponible para ese usuario.\n");
					return;
				}
			}
			if(Main.funcionalidades.get(option)!=null) {
				y.getMenu().anadirOpcion(Main.funcionalidades.get(option));
				System.out.println("\nSe ha añadido la opcion satisfactoriamente.\n");
			}
			else {
				System.out.println("\nOpcion invalida.\n");
			}
			
		} else {
			System.out.println("\nEl usuario no esta registrado.\n");
		}
	}
	
	/*Método toString.
	 * Retorna un String correspondiente al nombre de la funcionalidad, 
	 * que se mostrará por pantalla en el menú*/
	public String toString() {
		return "Agregar funcionalidad";
	}
}
