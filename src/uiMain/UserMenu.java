package uiMain;

import gestorAplicacion.Centro.Archivo;
import gestorAplicacion.Usuarios.*;
import java.util.*;

public class UserMenu extends OpcionDeMenu {
	public void ejecutar() {
		//Muestra las funcionalidades (menú) de un cierto usuario
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

	public String toString() {
		return "Funcionalidades del Usuario";
	}
}