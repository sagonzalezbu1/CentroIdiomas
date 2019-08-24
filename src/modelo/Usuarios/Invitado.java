package modelo.Usuarios;

import BaseDatos.Archivo;
import control.*;
import modelo.Centro.*;

/*Esta clase permite la generación de objetos de tipo invitado 
 * cada vez que se inicie la ejecución del programa y 
 * así mostrar el menú "estándar"*/
public class Invitado extends Usuario {
	//Constructor que permite la inicialización de atributos heredados de Usuario
	public Invitado(String name, long id, String email, String password) {
		super(name, id, email, password);
		//Se crea el menu de Invitado con las funcionalidades por defecto
		getMenu().anadirOpcion(new Ingresar());
		getMenu().anadirOpcion(Main.funcionalidades.get("Registrar"));
		getMenu().anadirOpcion(Main.funcionalidades.get("VerCursos"));
		getMenu().anadirOpcion(new Salir());
	}

	//Constructor por defecto de Invitado
	public Invitado() {
		this("", 0, "", "");
	}

	/*Método de inicio de sesión o Log In.
	 * Recibe como parámetros un long equivalente a la cédula 
	 * del usuario y un String correspondiente a la contraseña.
	 * Verifica que los datos sean correctos y ejecuta el menú del correspondiente usuario
	 * No devuelve nada*/
	static public void ingresar(long user, String key) {
		if(user == Archivo.getAdministrador().getCedula() && key.equals(Archivo.getAdministrador().getContrasena())) {
			Main.user = Archivo.getAdministrador();
			System.out.println("\nSe ha iniciado sesión.\n");
			return;
		}
		for (Usuario usuario : Archivo.getEstudiantes()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
		}
		for (Usuario usuario : Archivo.getDocentes()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
		}
		for (Usuario usuario : Archivo.getAdministrativos()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
		}
		System.out.println("\nDatos incorrectos.\n");
	}
}