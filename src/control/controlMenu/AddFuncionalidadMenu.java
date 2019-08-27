package control.controlMenu;

import java.util.*;

import BaseDatos.Archivo;
import control.OpcionDeMenu;
import modelo.Usuarios.*;

/*Esta clase es usada por el Administrador para agregar funcionalidades a 
 * los menús de los diferentes usuarios.
 * 
 * En esta clase se ejecuta el método anadirOpcion localizado en la clase MenuDeConsola.*/
public class AddFuncionalidadMenu extends OpcionDeMenu {
	
	/*Se hacen las respectivas verificaciones antes de agregar la funcionalidad,
	 * como por ejemplo que la funcionalidad no esté ya en el menú del usuario,
	 * que el usuario exista y que la funcionalidad exista.
	 * No recibe parámetros y no retorna nada*/
	public void ejecutar() {
		Scanner e = new Scanner(System.in);
		System.out.println("Ingrese la cedula del usuario al que desea agregar una funcionalidad: ");
		int cc = e.nextInt();
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
		
		if (user != null ) {
			System.out.println(Archivo.getAdministrador().SystemMenu());
			System.out.println("Ingrese la funcionalidad que quiere agregar: ");
			String option = e.next();
			ArrayList<OpcionDeMenu> menu= user.getMenu().getList();
			
			for(OpcionDeMenu opcion: menu) {
				if(opcion.getNombre().equals(option)) {
					System.out.println("\nLa opcion de menu ya esta disponible para ese usuario.\n");
					return;
				}
			}
			
			if(Main2.funcionalidades.get(option)!=null) {
				user.getMenu().anadirOpcion(Main2.funcionalidades.get(option));
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