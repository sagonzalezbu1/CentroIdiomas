package uiMain;

import gestorAplicacion.Usuarios.*;

public class CerrarSesion extends OpcionDeMenu {
	private String nombre="CerrarSesion";
	public String getNombre() {
		return nombre;
	}
	public void ejecutar() {
		//Se cierra sesi�n volviendo al men� de invitado
		Main.user = new Invitado();
	}
	public String toString() {
		return "Cerrar sesi�n";
	}
}