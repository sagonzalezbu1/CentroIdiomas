package control;

import java.util.*;

import control.controlMenu.RegistrarAdministrativoMenu;
import control.controlMenu.RegistrarDocenteMenu;
import control.controlMenu.RegistrarEstudianteMenu;

/*Esta clase es usada para gestionar los men�s de los usuarios, tanto mostrarlos como 
 * permitir que Administrador los modifique.*/
public class MenuDeConsola {
	Scanner entry = new Scanner(System.in);
	private ArrayList<OpcionDeMenu> Menu = new ArrayList<OpcionDeMenu>();

	public MenuDeConsola() {
	}

	//Submen� de la funcionalidad Registrar
	public MenuDeConsola(RegistrarEstudianteMenu RegistrarEstudianteMenu, RegistrarDocenteMenu RegistrarDocenteMenu,RegistrarAdministrativoMenu RegistrarAdministrativoMenu) {
		Menu.add(RegistrarEstudianteMenu);
		Menu.add(RegistrarDocenteMenu);
		Menu.add(RegistrarAdministrativoMenu);
	}

	/*M�todo para que el administrador agregue opciones a los usuarios
	 * Recibe como par�metro un objeto de tipo OpcionDeMenu, que ser� la que se a�ada.
	 * No retorna nada*/
	public void anadirOpcion(OpcionDeMenu option) {
		Menu.add(option);
	}
	
	/*M�todo para que el administrador elimine opciones a los usuarios.
	 * Recibe como par�metro un entero equivalente al n�mero de la opci�n a eliminar.
	 * No retorna nada*/
	public void eliminarOpcion(int opcion) {
		Menu.remove(opcion);
	}

	/*Ejecuci�n de los men�s, verificando que las opciones ingresadas sean las correctas.
	 * No recibe par�metros y no retorna nada*/
	public void lanzarMenu() {
		int cont = 0;
		
		for (OpcionDeMenu opcion : Menu) {
			System.out.println(cont + ". " + opcion);
			cont++;
		}
		
		System.out.println("\nIngrese el n�mero de la opci�n que desea ejecutar: ");
		String op = entry.next();
		
		try {
			ejecutarOpcion(Integer.parseInt(op));
		} catch (Exception ex) {
			System.out.println("\nHubo error en la escritura.\n");
		}
		
	}

	/*Ejecuci�n de la opci�n elegida por el usuario.
	 * Recibe como par�metro un entero equivalente a la opci�n elegida.
	 * No retorna nada*/
	private void ejecutarOpcion(int opcion) {
		Menu.get(opcion).ejecutar();
	}

	/*Retorna la lista con el men� del usuario
	 * No recibe par�metros*/
	public ArrayList<OpcionDeMenu> getList() {
		return Menu;
	}
}