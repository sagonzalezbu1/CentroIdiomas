package gestorAplicacion.usuarios;
import gestorAplicacion.Centro.*;
import uiMain.MenuDeConsola;
public class Invitado {
	private static Usuario y;
	private static MenuDeConsola menu;	
	static public Usuario ingresar(long user, String key) {
			for (Usuario x : Archivo.getEstudiantes()) {
				if (y.cedula == user && (y.contrasena).equals(key)) {
					y = x;
				}
			}
			if (y == null) {
				for (Usuario x : Archivo.getDocentes()) {
					if (y.cedula == user && (y.contrasena).equals(key)) {
						y = x;
					}
				}
			}
			if (y == null) {
				for (Usuario x : Archivo.getAdministrativos()) {
					if (y.cedula == user && (y.contrasena).equals(key)) {
						y = x;
					}
				}
			} 
			return y;
	}
	static public MenuDeConsola getMenu() {
		return menu;
	}
}