package uiMain;

import gestorAplicacion.Usuarios.*;

public class CerrarSesion extends OpcionDeMenu {
	public void ejecutar() {
		Main.user = new Invitado();
	}
	public String toString() {
		return "Cerrar sesión";
	}
}