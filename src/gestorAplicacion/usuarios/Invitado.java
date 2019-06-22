package gestorAplicacion.usuarios;

import gestorAplicacion.Centro.*;
import uiMain.MenuDeConsola;

public class Invitado {
	private static MenuDeConsola menu;

	static public Usuario ingresar(long user, String key) {
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				return x;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				return x;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				return x;
			}
		}
		return null;
	}

	static public MenuDeConsola getMenu() {
		return menu;
	}
}