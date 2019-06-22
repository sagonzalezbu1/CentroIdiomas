package uiMain;

import java.util.*;
import gestorAplicacion.usuarios.*;

public class Ingresar extends OpcionDeMenu {

	public void ejecutar() {
		Scanner entry = new Scanner(System.in);
		System.out.println("Ingrese su cedula :");
		long cc = entry.nextInt();
		System.out.println("Ingrese su contraseņa :");
		String pass = entry.next();
		Invitado.ingresar(cc, pass);
	}

	public String toString() {
		return "Ingresar";
	}
}
