package gestorAplicacion.usuarios;

import gestorAplicacion.Centro.*;
import uiMain.*;

public class Invitado extends Usuario {
	public Invitado(String name, long id, String email, String password) {
		super(name, id, email, password);
		getMenu().anadirOpcion(new Ingresar());
		getMenu().anadirOpcion(new Registrar());
	}

	public Invitado() {
		this("", 0, "", "");
	}

	static public void ingresar(long user, String key) {
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
			}
		}
	}
}