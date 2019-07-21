package uiMain;

import gestorAplicacion.Usuarios.*;
import gestorAplicacion.Centro.*;

public class SystemMenu extends OpcionDeMenu {
	public void ejecutar() {
		//Muestra todas las funcionalidades
		System.out.println("\n las funcionalidades del sistema son: \n");
		System.out.println(((Administrador) Main.user).SystemMenu());
	}
	
	public String toString() {
		return "Funcionalidades del Sistema";
	}

}
