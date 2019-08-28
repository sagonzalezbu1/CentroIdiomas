package modelo.Usuarios;


import control.*;
import defecto.Main;
import modelo.Centro.*;

/*Esta clase permite la generaci�n de objetos de tipo invitado 
 * cada vez que se inicie la ejecuci�n del programa y 
 * as� mostrar el men� "est�ndar"*/
public class Invitado extends Usuario {
	//Constructor que permite la inicializaci�n de atributos heredados de Usuario
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

	/*M�todo de inicio de sesi�n o Log In.
	 * Recibe como par�metros un long equivalente a la c�dula 
	 * del usuario y un String correspondiente a la contrase�a.
	 * Verifica que los datos sean correctos y ejecuta el men� del correspondiente usuario
	 * No devuelve nada*/
	static public void ingresar(long user, String key) {
		if(user == Main.admin.getCedula() && key.equals(Main.admin.getContrasena())) {
			Main.user = Main.admin;
			System.out.println("\nSe ha iniciado sesi�n.\n");
			return;
		}
		for (Usuario usuario : Estudiante.getEstudiantes()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesi�n.\n");
				return;
			}
		}
		for (Usuario usuario : Docente.getDocentes()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesi�n.\n");
				return;
			}
		}
		for (Usuario usuario : Administrativo.getAdministrativos()) {
			if (usuario.getCedula() == user && (usuario.getContrasena()).equals(key)) {
				Main.user = usuario;
				System.out.println("\nSe ha iniciado sesi�n.\n");
				return;
			}
		}
		System.out.println("\nDatos incorrectos.\n");
	}
}