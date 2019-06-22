package uiMain;

import gestorAplicacion.usuarios.*;

public class Main {
	public static Usuario user= new Invitado();
	public static void main(String[] args) {
		while(true) {
			user.getMenu().lanzarMenu();
			System.out.println("prueba");
		}
	}
}
