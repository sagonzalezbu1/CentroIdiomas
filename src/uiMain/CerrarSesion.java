package uiMain;

import gestorAplicacion.Usuarios.*;

public class CerrarSesion extends OpcionDeMenu {
	public void ejecutar() {
		//Se cierra sesión volviendo al menú de invitado
		Main.user = new Invitado();
	}
	public String toString() {
		return "Cerrar sesión";
	}
}