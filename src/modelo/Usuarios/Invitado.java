package modelo.Usuarios;


import control.*;
import defecto.Main;
import modelo.Centro.*;

/*Esta clase permite la generación de objetos de tipo invitado 
 * cada vez que se inicie la ejecución del programa y 
 * así mostrar el menú "estándar"*/
public class Invitado extends Usuario {
	//Constructor que permite la inicialización de atributos heredados de Usuario
	public Invitado(String name, long id, String email, String password) {
		super(name, id, email, password);
		//Se crea el menu de Invitado con las funcionalidades por defecto
		getProcesos().add("Ingresar");
		getProcesos().add(Main.funcionalidades.get("Registrar"));
		getProcesos().add(Main.funcionalidades.get("VerCursos"));
		getProcesos().add("Salir");
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
		if(user == Main.admin.getCedula() && key.equals(Main.admin.getContrasena())) {
			Main.user = Main.admin;
			System.out.println("\nSe ha iniciado sesión.\n");
			return;
		}
		for (Usuario usuario : Estudiante.getEstudiantes()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
		}
		for (Usuario usuario : Docente.getDocentes()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
		}
		for (Usuario usuario : Administrativo.getAdministrativos()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesión.\n");
				return;
			}
		}
		System.out.println("\nDatos incorrectos.\n");
	}
}