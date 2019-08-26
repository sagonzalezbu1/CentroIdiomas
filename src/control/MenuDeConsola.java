package control;

import java.util.*;

import control.controlMenu.RegistrarAdministrativoMenu;
import control.controlMenu.RegistrarDocenteMenu;
import control.controlMenu.RegistrarEstudianteMenu;

/*Esta clase es usada para gestionar los menús de los usuarios, tanto mostrarlos como 
 * permitir que Administrador los modifique.*/
public class MenuDeConsola {
	Scanner entry = new Scanner(System.in);
	private ArrayList<OpcionDeMenu> Menu = new ArrayList<OpcionDeMenu>();

	public MenuDeConsola() {
	}

	//Submenú de la funcionalidad Registrar
	public MenuDeConsola(RegistrarEstudianteMenu RegistrarEstudianteMenu, RegistrarDocenteMenu RegistrarDocenteMenu,RegistrarAdministrativoMenu RegistrarAdministrativoMenu) {
		Menu.add(RegistrarEstudianteMenu);
		Menu.add(RegistrarDocenteMenu);
		Menu.add(RegistrarAdministrativoMenu);
	}

	/*Método para que el administrador agregue opciones a los usuarios
	 * Recibe como parámetro un objeto de tipo OpcionDeMenu, que será la que se añada.
	 * No retorna nada*/
	public void anadirOpcion(OpcionDeMenu option) {
		Menu.add(option);
	}
	
	/*Método para que el administrador elimine opciones a los usuarios.
	 * Recibe como parámetro un entero equivalente al número de la opción a eliminar.
	 * No retorna nada*/
	public void eliminarOpcion(int opcion) {
		Menu.remove(opcion);
	}

	/*Ejecución de los menús, verificando que las opciones ingresadas sean las correctas.
	 * No recibe parámetros y no retorna nada*/
	public void lanzarMenu() {
		int cont = 0;
		
		for (OpcionDeMenu opcion : Menu) {
			System.out.println(cont + ". " + opcion);
			cont++;
		}
		
		System.out.println("\nIngrese el número de la opción que desea ejecutar: ");
		String op = entry.next();
		
		try {
			ejecutarOpcion(Integer.parseInt(op));
		} catch (Exception ex) {
			System.out.println("\nHubo error en la escritura.\n");
		}
		
	}

	/*Ejecución de la opción elegida por el usuario.
	 * Recibe como parámetro un entero equivalente a la opción elegida.
	 * No retorna nada*/
	private void ejecutarOpcion(int opcion) {
		Menu.get(opcion).ejecutar();
	}

	/*Retorna la lista con el menú del usuario
	 * No recibe parámetros*/
	public ArrayList<OpcionDeMenu> getList() {
		return Menu;
	}
}