package uiMain;

import gestorAplicacion.Usuarios.*;

public class CerrarSesion extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		Main.user = new Invitado();
	}
	public String toString() {
		return "Cerrar sesi�n";
	}
}