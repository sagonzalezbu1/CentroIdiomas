package uiMain;

import gestorAplicacion.Usuarios.*;
import java.util.*;

public class UserMenu extends OpcionDeMenu {
	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese el ID de la persona a la cual quiere verle las funcionalidades: ");
		long aux = entry.nextInt();
		System.out.println(((Administrador) Main.user).userSystemMenu(aux));
	}

	public String toString() {
		return "Opciones del Usuario";
	}

}



