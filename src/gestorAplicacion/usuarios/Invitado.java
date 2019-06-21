package gestorAplicacion.usuarios;
import gestorAplicacion.Centro.*;
public class Invitado {
	private static Usuario y;
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
}