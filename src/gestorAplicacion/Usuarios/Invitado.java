package gestorAplicacion.Usuarios;

import gestorAplicacion.Centro.*;
import uiMain.*;

public class Invitado extends Usuario {
	public Invitado(String name, long id, String email, String password) {
		super(name, id, email, password);
		getMenu().anadirOpcion(Main.funcionalidades.get("Ingresar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("Registrar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("CursosDisponibles"));
		getMenu().anadirOpcion(Main.funcionalidades.get("Cerrar"));
	}

	public Invitado() {
		this("", 0, "", "");
	}

	static public void ingresar(long user, String key) {
		if(user == Archivo.getAdministrador().getCedula() && key.equals(Archivo.getAdministrador().getContrasena())) {
			Main.user = Archivo.getAdministrador();
			return;
		}
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
				return;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
				return;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
				return;
			}
		}
		
	}
}

