package gestorAplicacion.Usuarios;

import gestorAplicacion.Centro.*;
import uiMain.*;

public class Invitado extends Usuario {
	//Constructor con menu
	public Invitado(String name, long id, String email, String password) {
		super(name, id, email, password);
		getMenu().anadirOpcion(new Ingresar());
		getMenu().anadirOpcion(Main.funcionalidades.get("Registrar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(new Salir());
	}

	//Constructor por defecto
	public Invitado() {
		this("", 0, "", "");
	}

	//Login
	static public void ingresar(long user, String key) {
		if(user == Archivo.getAdministrador().getCedula() && key.equals(Archivo.getAdministrador().getContrasena())) {
			Main.user = Archivo.getAdministrador();
			System.out.println("\nSe ha iniciado sesión.\n");
			return;
		}
		for (Usuario x : Archivo.getEstudiantes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
			else {
				System.out.println("\nCédula o contraseña incorrectos.\n");
				return;
			}
		}
		for (Usuario x : Archivo.getDocentes()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
			else {
				System.out.println("\nCédula o contraseña incorrectos.\n");
				return;
			}
		}
		for (Usuario x : Archivo.getAdministrativos()) {
			if (x.getCedula() == user && (x.getContrasena()).equals(key)) {
				Main.user = x;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
			else {
				System.out.println("\nCédula o contraseña incorrectos.\n");
				return;
			}
		}
	}
}