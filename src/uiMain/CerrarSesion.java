package uiMain;

import gestorAplicacion.Usuarios.*;

public class CerrarSesion extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Se cierra sesión volviendo al menú de invitado
		System.out.println("\nSe ha cerrado la sesión.\n");
		Main.user = new Invitado();
	}
	public String toString() {
		return "Cerrar sesión";
	}
}