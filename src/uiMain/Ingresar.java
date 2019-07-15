package uiMain;

import java.util.*;

import gestorAplicacion.Usuarios.*;

public class Ingresar extends OpcionDeMenu {
	
	public void ejecutar() {
		//Se inicia sesión con los datos del usuario
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese su cedula:");
		long cc = entry.nextInt();
		System.out.println("Ingrese su contraseña:");
		String pass = entry.next();
		Invitado.ingresar(cc, pass);
	}

	public String toString() {
		return "Ingresar";
	}
}